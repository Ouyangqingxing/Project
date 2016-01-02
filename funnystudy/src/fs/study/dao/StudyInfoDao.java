package fs.study.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import fs.study.model.StudyInfo;

/**学习情况的操作[增删(权限)查(1id 2按照时间查集合)]
 * @author Jason_★ 
 */
public interface StudyInfoDao
{
	//增-----------------------------------------------------
	/**增加一个学习情况
	 * @param conn 链接
	 * @param userId 用户id
	 * @param content 内容
	 * @throws SQLException
	 */
	public void daoAddStudyInfo(Connection conn,int userId,
			String content)throws SQLException;
	
	//删-----------------------------------------------------
	/** 删除学习情况
	 * @param conn 链接
	 * @param studyInfoId 学习情况id数组
	 * @throws SQLException
	 */
	public void daoDeleteStudyInfo(Connection conn,String[] studyInfoId
			)throws SQLException;
	
	//查-----------------------------------------------------
	/** 通过userId查询学习情况集合
	 * @param conn 链接
	 * @param userId 用户Id
	 * @return 学习情况集合
	 * @throws SQLException
	 */
	public List<StudyInfo> daoSelectStudyInfoByUesrId(Connection conn,int userId)throws SQLException;
	
	/**查询指定id的学习情况
	 * @param conn 链接
	 * @param userId 用户id 
	 * @return 学习情况
	 * @throws SQLException
	 */
	public StudyInfo daoSelectStudyInfoById(Connection conn,int userId)throws SQLException;

	/**
	 * @param conn
	 * @param userId
	 * @param time
	 * @return 学习情况
	 * @throws SQLException
	 */
	public StudyInfo daoSelectStudyInfoByUserIdandTime(Connection conn,int userId,String time)throws SQLException;
}
