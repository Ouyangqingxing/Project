package fs.battle.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


import fs.battle.dao.PlayerDaoByUser;
import fs.battle.dao.WuGongDaoByUser;
import fs.battle.model.Player;
import fs.common.util.ListAndString;
import fs.common.util.MathMethod;

/**PlayerDaoByUser的实现类
 * @author Jason_★ 
 */
public class PlayerDaoImpU implements PlayerDaoByUser
{
	//判断-----------------------------------------------------------------------------------
	@Override
	public boolean daoCheckUserName(Connection conn,String name)
	{
		PreparedStatement ps = null;
		ResultSet rs = null;

		try 
		{
			String sql = "select player_remark " +
					" from player where player_name = ? ";
			
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				rs = ps.executeQuery();
				rs.next();
				
				rs.getString("player_remark");
			
		} 
		catch (SQLException e1) 
		{
			return true; 
		}

		if(rs != null)
		{
			try 
			{
				rs.close();
				} 
			catch (SQLException e)
			{
				System.out.println("发生数据库异常啦！");
				e.printStackTrace();
			}
		}
		if(ps != null)
		{
			try
			{
				ps.close();
			}
			catch (SQLException e)
			{
				System.out.println("发生数据库异常啦！");
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Override
	public boolean daoCheckPlayerPhb(Connection conn, int playerId)
	{
		boolean result = false;	
		
		try
		{
			if(daoSelectPlayerSelfRanking(conn,playerId)<8)
			{
				return true;
			}
		}catch(Exception e){}
		
		for(int i = 0 ; i<7;i++)
		{
			if( getPlayerList(conn,7,1,1).get(i).getId() == playerId || 
				getPlayerList(conn,7,1,2).get(i).getId() == playerId ||
				getPlayerList(conn,7,1,3).get(i).getId() == playerId )
			{
				
				result = true;
				break;
			}
		}
		return result;
	}

	//增------------------------------------------------------------------------------------
	@Override
	public int daoAddPlayer(Connection conn,String name,int sex ,String remark) throws SQLException
	{		
		Random r1 = new Random();
		int campId =r1.nextInt(3)+1 ;
		
		PreparedStatement ps = null;

			String sql = "insert player(player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk)" +
					" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			
			int[] arr = MathMethod.getRandomThreeNumber(3);//abc
			int[] brr = MathMethod.getRandomThreeNumber(30);//xyz
			
			ps.setString(1, name);
			ps.setInt(2, sex);
			ps.setString(3, remark);
			int hp = 100+10*arr[0];
			int atk = 10+brr[0];
			int def = 10+brr[1];
			int spd = 5+brr[2];
			int rp = 1+arr[1];
			int critical = 1+arr[2];
			ps.setInt(4,  	hp  );//100+10*a
			ps.setInt(5,	atk );//10+x
			ps.setInt(6,	def );//10+y
			ps.setInt(7,	spd );//5+z
			ps.setInt(8,	rp );//1+b
			ps.setInt(9,0);
			ps.setInt(10,critical);//1+c
			ps.setInt(11,1);
			ps.setInt(12,0);
			
			List<Integer> l1 = new ArrayList<Integer>();
			l1.add(0);
			String s1 = ListAndString.ListToString(l1);
			
			ps.setString(13,s1);
			ps.setString(14,s1);
			ps.setString(15,s1);
			ps.setInt(16,campId);//
			ps.setInt(17,0);
			ps.setInt(18,0);
			ps.setInt(19,1);
			ps.setInt(20,0);
			ps.setInt(21,20);
			ps.setInt(22,0);
			ps.setInt(23,0);
			
			int population = getTotalItem(conn);
			ps.setInt(24,population+1);
			int power = hp*2+atk*13+def*11+spd*15+rp*150+critical*120;
			ps.setInt(25,power);//hp*2+atk*13+def*11+spd*15+rp*150+dodge*100+critical*120
			ps.setInt(26,0);
			
			ps.executeUpdate();

			if(ps != null)
			{
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			return campId;
	}

	//改------------------------------------------------------------------------------------
	@Override
	public void daoUpdatePlayerLv(Connection conn, int playerId,String backpack)
			throws SQLException 
	{
		PreparedStatement ps = null;
		String sql= "update player set player_backpack = ? where player_id=?";
		
		ps = conn.prepareStatement(sql);
	 
		ps.setString(1, backpack); 
		ps.setInt(2, playerId);   
		ps.executeUpdate();

		if(ps != null)
		{
			try 
			{
				ps.close();
			} 
			catch (SQLException e) 
			{
				System.out.println("发生数据库异常啦！");
				e.printStackTrace();
			}
		}		 
	}

	@Override
	public void daoUpdatePlayerBaseValue(Connection conn,int playerId, int hp, int atk,
			int def, int spd) throws SQLException
	{
		PreparedStatement ps = null;
		
		String sql = "update player set player_hp=player_hp+? ,player_atk = player_atk + ? , " +
				"player_def = player_def+? , player_spd = player_spd +?  where player_id=?";
		ps = conn.prepareStatement(sql);
		
		ps.setInt(1, hp);
		ps.setInt(2, atk);
		ps.setInt(3, def);
		ps.setInt(4, spd);
		ps.setInt(5, playerId); 
		
		ps.executeUpdate();

		if(ps != null)
		{
			try 
			{
				ps.close();
			} 
			catch (SQLException e) 
			{
				System.out.println("发生数据库异常啦！");
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void daoUpdatePlayerPoint(Connection conn, int playerId, int getPoints,int check)
			throws SQLException 
	{
		PreparedStatement ps = null;
		String sql = "";
		if(check == 9)
		{
			sql = "update player set player_points = player_points+? where player_id=?";
		}
		else if(check == 5)
		{
			sql = "update player set player_points = player_points-? where player_id=?";
		}
		ps = conn.prepareStatement(sql);
	 
		ps.setInt(1, getPoints); 
		ps.setInt(2, playerId); 
		
		ps.executeUpdate();

		if(ps != null)
		{
			try 
			{
				ps.close();
			} 
			catch (SQLException e) 
			{
				System.out.println("发生数据库异常啦！");
				e.printStackTrace();
			}
		}		 
	}

	@Override
	public void daoUpdatePlayerLV(Connection conn, int playerId) throws SQLException
	{
		PreparedStatement ps = null;
		
		String sql = "update player set player_lv=1 where player_id=?";
		ps = conn.prepareStatement(sql);
	 
		ps.setInt(1, playerId); 
		
		ps.executeUpdate();

		if(ps != null)
		{
			try 
			{
				ps.close();
			} 
			catch (SQLException e) 
			{
				System.out.println("发生数据库异常啦！");
				e.printStackTrace();
			}
		}		
	}

	@Override
	public void daoUpdatePlayerCoreCheck(Connection conn, int playerId, int check) throws SQLException
	{
		PreparedStatement ps = null;
		
		String sql = "";
		if(check == 1)
		{
			sql = "update player set player_corecheck = player_corecheck - 20000 where player_id=?";
		}
		else if(check == 0)
		{
			sql = "update player set player_corecheck = player_corecheck + 10000 where player_id=?";
		}	
			ps = conn.prepareStatement(sql);
	 
		ps.setInt(1, playerId); 
		
		ps.executeUpdate();

		if(ps != null)
		{
			try 
			{
				ps.close();
			} 
			catch (SQLException e) 
			{
				System.out.println("发生数据库异常啦！");
				e.printStackTrace();
			}
		}	
	}

	@Override
	public void daoUpdatePlayerBaseInfo(Connection conn,int playerId, String remark,int sex) throws SQLException
	{	
		PreparedStatement ps = null;
		
			String sql = "update player set player_remark=?,player_sex=? where player_id=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, remark);
			ps.setInt(2, sex);
			ps.setInt(3, playerId); 
			
			ps.executeUpdate();

			if(ps != null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
	}

	@Override
	public void daoUpdatePlayerHighValue(Connection conn, int playerId, int getRp,
			int getCritical, int getDodge) throws SQLException 
	{
		PreparedStatement ps = null;
		
		String sql = "update player set player_rp=player_rp+?,player_critical=player_critical+?,player_dodge=player_dodge+? where player_id=?";
		ps = conn.prepareStatement(sql);
		
		ps.setInt(1, getRp);
		ps.setInt(2, getCritical);
		ps.setInt(3, getDodge);
		ps.setInt(4, playerId); 
		
		ps.executeUpdate();

		if(ps != null)
		{
			try 
			{
				ps.close();
			} 
			catch (SQLException e) 
			{
				System.out.println("发生数据库异常啦！");
				e.printStackTrace();
			}
		}		 
	} 
		
	@Override
	public String daoUpdatePlayerLV(Connection conn,int playerId , int exp) throws SQLException
	{
		Player p1 = daoSelectPlayerAllInfo(conn,playerId);
		int oldLv = p1.getLv();
		int oldExp = p1.getExp();
		String info = "";
		//1、计算出所需经验
		int needExp = MathMethod.getNeedExp(oldLv)/2;//本级到下一级共需的经验
		//2、判断是否能升级	如果可以则修改 血攻防速 可分配点 以及lv++ exp=0
		if(oldExp+exp > needExp )
		{
			info = info + "您升级啦！各基础属性小幅度提高。<br>";
			int hp = (int) (p1.getHp()*1.2);
			int atk =(int) (p1.getAtk()*1.1);
			int def =(int) (p1.getDef()*1.1);
			int spd =(int) (p1.getSpd()*1.1);
			int points = p1.getPoints()+(oldLv*10);
			
			int rp = p1.getRp();
			int critical = p1.getCritical();
			int dodge = p1.getDodge();
			
			if(	(oldLv+1) % 5 == 0)//3、如果可以升级则判断即将升的是否为5的倍数	如果可以则修改 运闪暴 属性 否则不变
			{
				info = info + "您升到了 "+(oldLv+1)+" 级，进阶属性获得提高！<br>";
				//修改进阶属性
				rp ++ ;
				critical ++ ;
				dodge ++ ;
				
				if(oldLv == 9 && p1.getEquipment().size()<5)
				{
					info = info + "您升到了 "+(oldLv+1)+" 级，将习得一个新的武功！(目前至多习得3个)<br>";
					WuGongDaoByUser wu = new WuGongDaoImpU();
					PlayerDaoByUser pu = new PlayerDaoImpU();
					int number = wu.daoSelectWuGongNumber(conn); 
					boolean get = true;
					while(get)
					{ 
						Random random = new Random();
				        int WuGongId = random.nextInt(number)%(number-1+1) + 1;
						if (pu.daoUpdatePlayerWuGong(conn, p1.getId(), WuGongId, 9))//只有确定拿到武功后才退出循环
						{
							info = info + "您习得了  "+wu.daoSelectWuGong(conn, WuGongId).getName()+"！<br>";
							get=false;
						}
					}
				}
			} 
			
			//提高各属性
			
			PreparedStatement ps = null;

				String sql = "update player set player_hp=?,player_atk=?,player_def=?,player_spd=?,player_points=?,player_lv=?,player_exp=? ,player_rp = ?, player_critical = ?,player_dodge=?" +
						" where player_id=? ";
				ps = conn.prepareStatement(sql);
				
				ps.setInt(1, hp); 
				ps.setInt(2, atk); 
				ps.setInt(3, def); 
				ps.setInt(4, spd); 
				ps.setInt(5, points); 
				
				ps.setInt(6, (oldLv+1)); 
				ps.setInt(7, 0); 
				
				ps.setInt(8, rp); 
				ps.setInt(9, critical); 
				ps.setInt(10, dodge); 
				
				ps.setInt(11, playerId); 
				
				ps.executeUpdate();
			
				if(ps != null)
				{
					try 
					{
						ps.close();
					} 
					catch (SQLException e) 
					{
						System.out.println("发生数据库异常啦！");
						e.printStackTrace();
					}
				}	
		}
		else//只更新经验属性
		{
			
			PreparedStatement ps = null;
		
				String sql = "update player set player_exp=? " +
						" where player_id=? ";
				ps = conn.prepareStatement(sql);
		
				ps.setInt(1, (oldExp+exp) ); 
				ps.setInt(2, playerId); 
				
				ps.executeUpdate();
			
				if(ps != null)
				{
					try 
					{
						ps.close();
					} 
					catch (SQLException e) 
					{
						System.out.println("发生数据库异常啦！");
						e.printStackTrace();
					}
				}
		}
		return info;
	}

	@Override
	public void daoUpdatePlayerWeapon(Connection conn,int playerId, int weaponId, int check) throws SQLException//因需要武器类配合 未完成
	{
			List<Integer> weapon = ListAndString.StringToList(daoSelectPlayerWEB(conn,playerId,2));//拿到玩家已拥有武器集合
			
			int check2 = 0;
			if(weapon == null)
			{
				check2 = 1; //1表示什么装备也没有
			}
			else if(weapon.contains(weaponId)==false)
			{
				check2 = 2;//有武器，但是玩家不拥有该武器
			}
			else if(weapon.contains(weaponId))
			{
				check2 = 3;//玩家拥有该武器
			}
			
			if(   check == 9 &&  (check2 == 2 || check2 == 1 )	)//选择获取该武器  并且 玩家不拥有该武器】
			{
				weapon.add(weaponId);//讲新武器id加入集合
				String newWeaponInfo =  ListAndString.ListToString(weapon);//按照格式转化成string

				
				PreparedStatement ps = null;
			
					String sql = "update player set player_equipment=? where player_id=?";
					ps = conn.prepareStatement(sql);
					
					ps.setString(1, newWeaponInfo);
					ps.setInt(2, playerId); 
					
					ps.executeUpdate();
			
					if(ps != null)
					{
						try 
						{
							ps.close();
						} 
						catch (SQLException e) 
						{
							System.out.println("发生数据库异常啦！");
							e.printStackTrace();
						}
					}
			}
			else if( check == 5 && check2 == 3 )// 玩家丢失对应weaponId的武器 并且玩家之前应该拥有该武器
			{
				 Iterator<Integer> iter = weapon.iterator(); //在集合中删除该武器 
				 while(iter.hasNext())
				 {  
				     Integer s = iter.next();  
				     if(s == weaponId)
				     {  
				         iter.remove();  
				     }  
				 }  	 
				String newWeaponInfo =  ListAndString.ListToString(weapon);//按照格式转化成string

				
				PreparedStatement ps = null;

					String sql = "update player set player_equipment=? where player_id=?";
					ps = conn.prepareStatement(sql);
					
					ps.setString(1, newWeaponInfo);
					ps.setInt(2, playerId); 
					
					ps.executeUpdate();

					if(ps != null)
					{
						try 
						{
							ps.close();
						} 
						catch (SQLException e) 
						{
							System.out.println("发生数据库异常啦！");
							e.printStackTrace();
						}
					}	
			}
			else//什么都不做，返回错误提示 
			{
				System.out.println("【错误提示】：你已经拥有该武器无法获得 或是 你没有该武器无法丢失");
			}		
	}

	@Override
	public boolean daoUpdatePlayerWuGong(Connection conn,int playerId, int wugongId,int check)throws SQLException //因需要武功类配合 未完成
	{
			boolean result = false;
			List<Integer> wugong = ListAndString.StringToList(daoSelectPlayerWEB(conn,playerId,1));//拿到玩家已拥有武功集合
			
			if(wugong.size()<5)
			{
				int check2 = 0;
//				if(wugong == null)
//				{
//					check2 = 1; //1表示什么武功也没有
//				}
				if(wugong.contains(wugongId)==false)
				{
					check2 = 2;//有武功，但是玩家不拥有该武功
				}
				else if(wugong.contains(wugongId))
				{
					check2 = 3;//玩家拥有该武功
				}
				
				if(check == 9 &&  (check2 == 2 || check2 == 1 ) )//选择获取该武功  并且 玩家不拥有该武功】
				{
					wugong.add(wugongId);//讲新武功id加入集合
					String newWugongInfo =  ListAndString.ListToString(wugong);//按照格式转化成string
	
					
					PreparedStatement ps = null;
						String sql = "update player set player_wugong=? where player_id=?";
						ps = conn.prepareStatement(sql);
						
						ps.setString(1, newWugongInfo);
						ps.setInt(2, playerId); 
						
						ps.executeUpdate();
						if(ps != null)
						{
							try 
							{
								ps.close();
							} 
							catch (SQLException e) 
							{
								System.out.println("发生数据库异常啦！");
								e.printStackTrace();
							}
						}	
						return true;
				}
				else if(check == 5 && check2 == 3)// 玩家遗忘对应武功 并且 玩家之前应该拥有该武功
				{
					 Iterator<Integer> iter = wugong.iterator(); //在集合中删除该武功 
					 while(iter.hasNext())
					 {  
					     Integer s = iter.next();  
					     if(s == wugongId)
					     {  
					         iter.remove();  
					     }  
					 }  	 
					String newWugongInfo =  ListAndString.ListToString(wugong);//按照格式转化成string
	
					PreparedStatement ps = null;
						String sql = "update player set player_wugong=? where player_id=?";
						ps = conn.prepareStatement(sql);
						
						ps.setString(1, newWugongInfo);
						ps.setInt(2, playerId); 
						
						ps.executeUpdate();
	
						if(ps != null)
						{
							try 
							{
								ps.close();
							} 
							catch (SQLException e) 
							{
								System.out.println("发生数据库异常啦！");
								e.printStackTrace();
							}
						}
					}
					else//什么都不做，返回错误提示 
					{
						System.out.println("【错误提示】：修改武功信息有误，请检查参数");
					}
			}
			return result;
		}
	
	@Override
	public void daoUpdatePlayerCoreCheck(Connection conn,int playerId, int oldCoreCheck,int getCoreCheck)throws SQLException
	{	
		PreparedStatement ps = null;
			String sql = "update player set player_coreCheck=? where player_id=?";
			ps = conn.prepareStatement(sql);
			
			//拥有正义点的玩家一旦残杀立刻清零正义点，拥有恶意点的人疗伤仅减少恶意点。
			//这里getCoreCheck小于0即为选择残杀  oldCoreCheck>0即为仙侠
			if(getCoreCheck<0 && oldCoreCheck>0)
			{
				ps.setInt(1, 0);
			}
			else//其他情况包括恶人 选择残杀或治疗  仙侠选择治疗均直接相加即可。
			{
				ps.setInt(1, (oldCoreCheck+getCoreCheck));
			}
			
			ps.setInt(2, playerId); 
			ps.executeUpdate();
			if(ps != null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
	}

	@Override
	public void daoUpdatePlayerState(Connection conn,int playerId, int state) throws SQLException
	{	
		PreparedStatement ps = null;
			String sql = "update player set player_state=? where player_id=?";
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, state);
			ps.setInt(2, playerId); 
			
			ps.executeUpdate();

			if(ps != null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}	
	}

	@Override
	public void daoUpdatePlayerXiuWei(Connection conn,int playerId,int XiuWei, int check)throws SQLException
	{	
		if(XiuWei>100000){XiuWei=100000;}
		PreparedStatement ps = null;
	
			int oldXiuwei = daoSelectPlayerAllInfo(conn,playerId).getXiuwei();
			String sql = "update player set player_xiuwei=? where player_id=?";
			ps = conn.prepareStatement(sql);
			if(check == 9)
			{
				ps.setInt(1, (oldXiuwei+XiuWei));
				ps.setInt(2, playerId); 
			}
			else if(check == 5)
			{
				ps.setInt(1, (oldXiuwei-XiuWei));
				ps.setInt(2, playerId); 
			}
			ps.executeUpdate();

			if(ps != null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
	}
	
	@Override
	public void daoUpdatePlayerBuff(Connection conn,int playerId, int buff) throws SQLException
	{		
			PreparedStatement ps = null;
	
			String sql = "update player set player_buff=? where player_id=?";
			ps = conn.prepareStatement(sql);
		
			ps.setInt(1, buff);
			ps.setInt(2, playerId); 
		
			ps.executeUpdate();
			if(ps != null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
	}

	@Override
	public void daoUpdatePlayerLastFightChance(Connection conn,int playerId, int check)throws SQLException
	{	
		PreparedStatement ps = null;

			if(check == 9)
			{
				String sql = "update player set player_lastfightchance=player_lastfightchance+1 where player_id=?";
				ps = conn.prepareStatement(sql); 
				ps.setInt(1, playerId); 
			}
			else if(check == 5)
			{ 
				String sql = "update player set player_lastfightchance=player_lastfightchance-1 where player_id=?";
				ps = conn.prepareStatement(sql); 
				ps.setInt(1, playerId); 
			}
			ps.executeUpdate();

			if(ps != null)
			{
				try 
				{
					ps.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
	} 
	
	@Override
	public void daoUpdatePlayerRanking(Connection conn, int playerId,
			int bePlayerId) throws SQLException
	{
		int ranking1 = daoSelectPlayerSelfRanking(conn,playerId);
		int ranking2 = daoSelectPlayerSelfRanking(conn,bePlayerId);
		
		if(ranking1 > ranking2)
		{
			PreparedStatement ps1 = null;
			PreparedStatement ps2 = null;
			
			String sql1 = "update player set player_ranking=? where player_id=?";
			String sql2 = "update player set player_ranking=? where player_id=?";
			ps1 = conn.prepareStatement(sql1);
			ps2 = conn.prepareStatement(sql2);
			
			ps1.setInt(1, ranking2);
			ps1.setInt(2, playerId); 
			ps1.executeUpdate();
			
			ps2.setInt(1, ranking1);
			ps2.setInt(2, bePlayerId); 
			ps2.executeUpdate();			
			
			if(ps1 != null)
			{
				try 
				{
					ps1.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			if(ps2 != null)
			{
				try 
				{
					ps2.close();
				} 
				catch (SQLException e) 
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void daoUpdatePlayerPK(Connection conn, int playerId, int check) throws SQLException
	{
		PreparedStatement ps = null;
		
		String sql = "update player set player_pk=? where player_id=?";
		ps = conn.prepareStatement(sql);
	
		ps.setInt(1, check);
		ps.setInt(2, playerId); 
	
		ps.executeUpdate();
		if(ps != null)
		{
			try 
			{
				ps.close();
			} 
			catch (SQLException e) 
			{
				System.out.println("发生数据库异常啦！");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void daoUpdatePlayerPower(Connection conn, int playerId) throws SQLException
	{
		PreparedStatement ps = null;
		
		String sql = "update player set player_power=? where player_id=?";
		ps = conn.prepareStatement(sql);
		
		Player p1 = daoSelectPlayerAllInfo(conn,playerId);
		int power = (int)(p1.getHp()*0.2)+p1.getAtk()*13+p1.getDef()*11+p1.getSpd()*15+p1.getRp()*150+p1.getDodge()*100+p1.getCritical()*120;
		//hp*0.2+atk*13+def*11+spd*15+rp*150+dodge*100+critical*120
		ps.setInt(1, power);
		ps.setInt(2, playerId); 
	
		ps.executeUpdate();
		if(ps != null)
		{
			try 
			{
				ps.close();
			} 
			catch (SQLException e) 
			{
				System.out.println("发生数据库异常啦！");
				e.printStackTrace();
			}
		}
	}
	
	//查------------------------------------------------------------------------------------
	@Override
	public Player daoSelectPlayerAllInfo(Connection conn,int playerId) throws SQLException
	{	
		PreparedStatement ps = null;
		ResultSet rs = null;
			String sql = "select  player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_pk,player_power,player_ranking from player where player_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, playerId);
			rs = ps.executeQuery();
			rs.next();
			 
			Player player = new Player();
			
			player.setId		(playerId);
			player.setName		(rs.getString	("player_name"));
			player.setSex		(rs.getInt	("player_sex"));
			player.setRemark	(rs.getString	("player_remark"));
			player.setHp		(rs.getInt	("player_hp"));
			player.setAtk		(rs.getInt	("player_atk"));
			player.setDef		(rs.getInt	("player_def"));
			player.setSpd		(rs.getInt	("player_spd"));
			player.setRp		(rs.getInt	("player_rp"));
			player.setCritical	(rs.getInt	("player_critical"));
			player.setDodge		(rs.getInt	("player_dodge"));
			player.setLv		(rs.getInt	("player_lv"));
			player.setExp		(rs.getInt	("player_exp"));
			
			player.setWugong	(ListAndString.StringToList( rs.getString	("player_wugong")));
			player.setEquipment	(ListAndString.StringToList( rs.getString	("player_equipment")));
			player.setBackpack	(ListAndString.StringToList( rs.getString	("player_backpack")));
			
			player.setCampId		(rs.getInt	("player_campId"));
			player.setTeamId		(rs.getInt	("player_teamId"));
			player.setCoreCheck		(rs.getInt	("player_coreCheck"));
			player.setState		(rs.getInt	("player_state"));
			player.setBuff		(rs.getInt	("player_buff"));
			player.setLastFightChance		(rs.getInt	("player_lastFightChance"));
			player.setXiuwei(rs.getInt	("player_xiuwei"));
			player.setPoints(rs.getInt	("player_points"));
			player.setRanking(rs.getInt	("player_ranking"));
			player.setPk(rs.getInt	("player_pk"));
			player.setPower(rs.getInt	("player_power"));
			
			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			if(ps != null)
			{
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			return player;
	}
	
	@Override
	public int daoSelectPlayerSelfRanking(Connection conn,int playerId) throws SQLException
	{	
		PreparedStatement ps = null;
		ResultSet rs = null;
			String sql = "select  player_ranking from player where player_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, playerId);
			rs = ps.executeQuery();
			rs.next();
			
			int ranking = rs.getInt	("player_ranking");
		
			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			if(ps != null)
			{
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			return ranking;
	}
	
	@Override
	public String daoSelectPlayerWEB(Connection conn,int playerId, int choose) throws SQLException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;

			String sql = "select player_wugong,player_equipment,player_backpack from player " +
					" where player_id = ? ";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, playerId);
			rs = ps.executeQuery();
			rs.next();
			
			
			String wugong = rs.getString	("player_wugong");
			String equipment=rs.getString	("player_equipment") ;
			String backpack =rs.getString	("player_backpack");
			
			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			if(ps != null)
			{
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			
			if(choose == 1){return wugong;}
			else if(choose == 2){return equipment;}
			else if(choose == 3){return backpack;}
			else{return null;}
	}

	@Override
	public int daoSelectPlayerIdByName(Connection conn,String name)throws SQLException
	{
		PreparedStatement ps = null;
		ResultSet rs = null;

			String sql = "select  player_id from player where player_name = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			rs.next();		 
			int id = rs.getInt("player_id");
			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			if(ps != null)
			{
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			return id;
		}

	@Override
	public List<Player> daoSelectPlayerRanking(Connection conn, int choose)
			throws SQLException 
	{
		Statement stat = null;
		ResultSet rs = null;
	
			stat = conn.createStatement();
			
			String sql = null;
			
			if(choose == 1)
			{
				sql = "select player_id,player_name,player_lv,player_coreCheck " +
						" from player order by player_coreCheck desc limit 7";
			}
			else if(choose == 2)
			{
				sql = "select player_id,player_name,player_lv,player_coreCheck " +
						" from player order by player_coreCheck limit 7";
			}
			else if(choose == 3)
			{
				sql = "select player_id,player_name,player_lv,player_coreCheck " +
						" from player order by player_lv desc limit 7";
			} 
			else
			{
				sql = "select player_id,player_name,player_lv,player_coreCheck " +
						" from player order by player_ranking limit 7";
			}
					
			rs = stat.executeQuery(sql);
			List<Player> playerList = new ArrayList<Player>();
			while(rs.next())
			{
				Player player = new Player();
				
				player.setId		(rs.getInt		("player_id"));
				player.setName		(rs.getString	("player_name"));
				player.setLv		(rs.getInt	("player_lv"));
				player.setCoreCheck		(rs.getInt	("player_coreCheck"));
				
				playerList.add(player);
			}
			
			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			if(stat != null)
			{
				try
				{
					stat.close();
				}
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			return playerList;
	} 	
	
	@Override
	public int getTotalItem(Connection conn) 
	{ 
		Statement stat = null;
		ResultSet rs = null;
		int totalItem = 0;
		try 
		{ 
			stat = conn.createStatement();
			String sql = "select count(player_id) as totalItem from player";
			rs = stat.executeQuery(sql);
			rs.next();
			totalItem = rs.getInt("totalItem");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stat!=null){
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return totalItem;
	}

	@Override
	public List<Player> getPlayerList(Connection conn,int eachPage, int currentPage,int choose) 
	{ 
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Player> playerList = new ArrayList<Player>();
		try 
		{ 
			String sql = null;
			if(choose == 1)//xj
			{
				sql = "select player_id,player_name,player_lv,player_power " +
						" from player order by player_corecheck desc limit ?,? ";
			}
			else if(choose == 2)//xx
			{
				sql = "select player_id,player_name,player_lv,player_power " +
						" from player order by player_corecheck limit ?,? ";
			}
			else if(choose == 4)//ranking
			{
				sql = "select player_id,player_name,player_lv,player_power " +
						" from player order by player_ranking limit ?,? ";
			}
			else//lv
			{
				sql = "select player_id,player_name,player_lv,player_power " +
						" from player order by player_lv desc limit ?,? ";
			}
						
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, (currentPage-1)*eachPage); //0 10 eachPage=10 1
			ps.setInt(2, eachPage);  
			
			rs = ps.executeQuery();
			
			int a = 1;//为了拿到具体的名词
			while(rs.next())
			{
				Player p1 = new Player();
				
				p1.setId		(rs.getInt	("player_id")); 
				p1.setName		(rs.getString	("player_name"));
				p1.setLv		(rs.getInt	("player_lv")); 
				p1.setPower		(rs.getInt	("player_power")); 
				p1.setSex((currentPage-1)*eachPage+a);
				a++;
				
				playerList.add(p1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ps!=null){
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return playerList;
	}

	@Override
	public Player daoSelectPlayerInfoByRanking(Connection conn, int ranking)
			throws SQLException 
	{
		PreparedStatement ps = null;
		ResultSet rs = null;
			String sql = "select player_id,player_name,player_remark,player_lv,player_power,player_ranking from player where player_ranking = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, ranking);
			rs = ps.executeQuery();
			rs.next();
			 
			Player player = new Player();
			
			player.setId		(rs.getInt	("player_id"));	
			player.setName(rs.getString	("player_name"));
			player.setRemark	(rs.getString	("player_remark"));		 
			player.setLv		(rs.getInt	("player_lv"));
			daoUpdatePlayerPower(conn,player.getId());
			player.setPower		(rs.getInt	("player_power"));
			player.setRanking	(rs.getInt	("player_ranking"));
					
			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			if(ps != null)
			{
				try
				{
					ps.close();
				}
				catch (SQLException e)
				{
					System.out.println("发生数据库异常啦！");
					e.printStackTrace();
				}
			}
			return player;
	}
	
//	@Override
//	public void daoUpdatePlayerTeamId(Connection conn,int playerId,int teamId)throws SQLException 
//	{
//		PreparedStatement ps = null;
//		
//		String sql = "update player set player_teamId=? where player_id=?";
//		ps = conn.prepareStatement(sql);
//		
//		ps.setInt(1, teamId);
//		ps.setInt(2, playerId); 
//		
//		ps.executeUpdate();
//
//		if(ps != null)
//		{
//			try 
//			{
//				ps.close();
//			} 
//			catch (SQLException e) 
//			{
//				System.out.println("发生数据库异常啦！");
//				e.printStackTrace();
//			}
//		}
//	}
}	