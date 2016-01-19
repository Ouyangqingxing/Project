-- 建立数据库并且设置编码为utf-8 
CREATE DATABASE `funnystudy`
CHARACTER SET 'utf8'
COLLATE 'utf8_general_ci';
 
-- 开启数据库的事件
use funnystudy;
set global event_scheduler =1; 

-- 新增每日更新挑战次数事件（注意开始时间 循环周期 和具体操作，如有需求可以更改）
create event updateFightChance
on schedule every 1 day starts timestamp '2015-12-22 22:00:00'
do update Player set player_lastFightChance=20;

-- 玩家表
create table Player
(
		  player_id int auto_increment not null PRIMARY key,
			player_name varchar(15) not null,
			player_sex int not null,
			player_remark varchar(100) not null,
	
			player_hp int not null,
			player_atk int not null,
			player_def int not null,
			player_spd int not null,
			player_rp int not null,
			player_critical int not null,
			player_dodge int not null,
			player_lv int not null,
			player_exp int not null,

			player_wugong varchar(100) ,
			player_equipment varchar(100),
			player_backpack varchar(100) ,
			
			player_campId int not null,
			player_teamId int not null,
			
			player_coreCheck int not null,
			player_state int not null,
			player_buff int not null,
			player_lastFightChance int not null,
			player_xiuwei int not null,
			player_points int not null,
			player_ranking int not null,
			player_power int not null,
			player_pk int not null

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 玩家表新增数据
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★阿青★","0","",1500000000,5000000,3000000,400000,10,10,10,10,1,"0,","0,","3,",0,0,1,1,0,1,1,1,1,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★飞蓬★","1","",2000000000,5000000,5000000,200000,10,10,10,10,1,"0,","0,","3,",0,0,2,1,0,1,1,1,2,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★重楼★","1","",500000000,10000000,10000000,1000000,3,3,3,10,1,"0,","0,","-3,",0,0,3,1,0,1,1,1,3,1,0);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★李寻欢★","1","",1500000000,3000000,3000000,500000,10,10,10,10,1,"0,","0,","3,",0,0,4,1,0,1,1,1,4,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★郭靖★","1","",600000000,100000,900000,30000,10,10,10,5,1,"0,","0,1,","2,",0,0,5,1,0,1,1,1,5,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★欧阳锋★","1","",10000000,200000,50000,100000,10,10,10,5,1,"0,","0,2,","-2,",0,0,-1,1,0,1,1,1,6,1,0);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★邀月★","0","",20000000,150000,50000,100000,10,10,10,5,1,"0,","0,3,","-2,",0,0,-2,1,0,1,1,1,7,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★李逍遥★","1","",500000000,100000,100000,50000,10,10,10,5,1,"0,","0,4,","2,",0,0,6,1,0,1,1,1,8,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★赵灵儿★","0","",500000000,200000,200000,500000,10,10,10,5,1,"0,","0,5,","2,",0,0,7,1,0,1,1,1,9,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★木道人★","1","",10000000,100000,100000,100000,10,10,10,5,1,"0,","0,","-2,",0,0,-3,1,0,1,1,1,10,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★陆小凤★","1","",500000000,50000,150000,30000,10,10,10,3,1,"0,","0,","1,",0,0,8,1,0,1,1,1,11,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★花满楼★","1","",300000000,150000,50000,80000,10,10,10,3,1,"0,","0,","1,",0,0,9,1,0,1,1,1,12,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★叶孤城★","1","",10000000,200000,80000,80000,10,10,10,3,1,"0,","0,","-1,",0,0,-4,1,0,1,1,1,13,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★孟星魂★","1","",1000000000,100000,100000,100000,10,10,10,3,1,"0,","0,","1,",0,0,10,1,0,1,1,1,14,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★律香川★","1","",500000000,100000,100000,50000,10,10,10,3,1,"0,","0,","3,",0,0,-5,1,0,1,1,1,15,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★林诗音★","0","",500000000,200000,200000,500000,10,10,10,3,1,"0,","0,","2,",0,0,11,1,0,1,1,1,16,1,1);

insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★姜风★","0","",800000000,200000,200000,100000,5,5,5,2,1,"0,","0,","2,",0,0,12,1,0,1,1,1,17,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★叶汐★","0","",5000,500,50,100,5,5,5,1,1,"0,","0,","2,",0,0,13,1,0,1,1,1,18,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★欧阳辰★","0","",500000000,150000,100000,80000,5,5,5,2,1,"0,","0,","2,",1,0,14,1,0,1,1,1,19,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★黯邪★","0","",300000000,200000,100000,100000,5,5,5,2,1,"0,","0,","2,",2,0,-6,1,0,1,1,1,20,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★祈灵★","0","",300000000,100000,50000,200000,5,5,5,2,1,"0,","0,","2,",3,0,15,1,0,1,1,1,21,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★墨青玄★","0","",700000,5000,5000,3000,5,5,5,2,1,"0,","0,","2,",1,0,16,1,0,1,1,1,22,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★百里寒修★","0","",300000,8000,5000,5000,5,5,5,2,1,"0,","0,","2,",2,0,-7,1,0,1,1,1,23,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★祈玉★","0","",300000,5000,5000,7000,5,5,5,2,1,"0,","0,","2,",3,0,17,1,0,1,1,1,24,1,1);

insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★行走江湖的少年★","0","",20000,500,200,500,3,3,3,1,1,"0,","0,","2,",0,0,18,1,0,1,1,1,25,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★机智的少女★","0","",5000,100,50,100,3,3,3,1,1,"0,","0,","2,",0,0,19,1,0,1,1,1,26,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★小巷里的流浪汉★","0","",10000,200,100,200,3,3,3,1,1,"0,","0,","2,",0,0,20,1,0,1,1,1,27,1,1);
insert Player (player_name,player_sex,player_remark,player_hp,player_atk,player_def,player_spd,player_rp,player_critical,player_dodge,player_lv,player_exp,player_wugong,player_equipment,player_backpack,player_campId,player_teamId,player_coreCheck,player_state,player_buff,player_lastFightChance,player_xiuwei,player_points,player_ranking,player_power,player_pk) 
values ("★练习用的木头人★","0","",1000,50,50,50,3,3,3,1,1,"0,","0,","2,",0,0,21,1,0,1,1,1,28,1,1);

-- 阵营表
create table Camp
(
		  camp_id int auto_increment not null PRIMARY key,
			camp_name varchar(20) not null,
			camp_population int not null,
			camp_remark varchar(100) not null,
			camp_teamNumber int not null

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 阵营表新增数据
insert Camp (camp_name,camp_population,camp_remark,camp_teamNumber) values ("正义萌",2,"为了心中不会熄灭的正义之火！",0);
insert Camp (camp_name,camp_population,camp_remark,camp_teamNumber) values ("魅邪教",2,"世间繁华，无所不同",0);
insert Camp (camp_name,camp_population,camp_remark,camp_teamNumber) values ("浣月宫",2,"浣花洗剑",0);

-- 帮会表
create table Team
(
		  team_id int auto_increment not null PRIMARY key,
			camp_id int not null,
			foreign key (camp_id) references Camp(camp_id),
			team_leaderId int not null,
			team_viceLeaderId int ,
			team_name varchar(20) not null,
			team_remark varchar(100) not null,
			team_exp int not null,
			team_level int not null,
			team_population int not null,
			team_sign int not null
 
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 武器表
create table Weapon 
(
			weapon_id int auto_increment not null PRIMARY key,
			weapon_type int not null, 
			weapon_holderId int not null, 
			weapon_name varchar(20) not null,
			weapon_remark varchar(100) not null,
			weapon_buffName int not null,
			weapon_buffPower int not null,
			weapon_specialNumber int not null

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
 
-- 武器表新增数据
insert Weapon (weapon_type, weapon_holderId, weapon_name, weapon_remark, weapon_buffName ,weapon_buffPower,weapon_specialNumber) values 
							(1,5,"倚天剑","此剑出匣后不饮人血，不便还鞘。（攻击增加至300%）",1,300,0);
insert Weapon (weapon_type, weapon_holderId, weapon_name, weapon_remark, weapon_buffName ,weapon_buffPower,weapon_specialNumber) values 
							(2,6,"屠龙刀","倚天不出，谁与争锋?（攻击和防御增加至200%）",9,200,0);
insert Weapon (weapon_type, weapon_holderId, weapon_name, weapon_remark, weapon_buffName ,weapon_buffPower,weapon_specialNumber) values 
							(4,7,"天魔琴","琴声悠悠，人心惶惶。（速度增加至200%，运势提高20%）",8,200,0);
insert Weapon (weapon_type, weapon_holderId, weapon_name, weapon_remark, weapon_buffName ,weapon_buffPower,weapon_specialNumber) values 
							(1,8,"七星剑","剑身镶嵌七颗金黄宝石，可吸取北斗七星之精气。（攻击和速度增加至200%）",7,200,0);
insert Weapon (weapon_type, weapon_holderId, weapon_name, weapon_remark, weapon_buffName ,weapon_buffPower,weapon_specialNumber) values 
							(4,9,"天蛇杖","女娲族历代相传，拥有世间罕见的灵力。（攻击增加至200%，暴击提高20%）",10,200,0);

-- 武功表
create table WuGong
(
			wugong_id int auto_increment not null PRIMARY key, 
			wugong_type int not null,
			wugong_name varchar(20) not null,
			wugong_remark varchar(100) not null,
			wugong_buffName int not null,
			wugong_buffPower int not null,
			wugong_buffRound int not null,
			wugong_hits int not null,
			wugong_specialNumber int not null

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 武功表新增数据
insert WuGong (WuGong_type,WuGong_name,WuGong_remark,WuGong_buffName,WuGong_buffPower,WuGong_buffRound,WuGong_hits,wugong_specialNumber) 
values (1,"乾坤大挪移","功法源自波斯明教，乃镇教之宝。（将受到的伤害3倍返还给对手）",0,300,0,0,0);

insert WuGong (WuGong_type,WuGong_name,WuGong_remark,WuGong_buffName,WuGong_buffPower,WuGong_buffRound,WuGong_hits,wugong_specialNumber) 
values (2,"降龙十八掌","武林中威震天下的镇帮神功。（对敌方造成5倍攻击的伤害）",1,500,0,0,0);

insert WuGong (WuGong_type,WuGong_name,WuGong_remark,WuGong_buffName,WuGong_buffPower,WuGong_buffRound,WuGong_hits,wugong_specialNumber) 
values (2,"黯然销魂掌","黯然销魂者，唯别而已矣。（必中！对敌方造成2倍攻击的伤害）",1,200,0,0,-1);

insert WuGong (WuGong_type,WuGong_name,WuGong_remark,WuGong_buffName,WuGong_buffPower,WuGong_buffRound,WuGong_hits,wugong_specialNumber) 
values (2,"吸星大法","出自日月神教教主任我行的武功。（对敌方造成2倍攻击的伤害并回复等量的体力）",1,200,0,0,-2); 

insert WuGong (WuGong_type,WuGong_name,WuGong_remark,WuGong_buffName,WuGong_buffPower,WuGong_buffRound,WuGong_hits,wugong_specialNumber) 
values (2,"凌波微步","逍遥派的独门轻功步法，步法精妙异常。（你的速度提高到3倍，持续3回合）",3,300,3,0,0); 

insert WuGong (WuGong_type,WuGong_name,WuGong_remark,WuGong_buffName,WuGong_buffPower,WuGong_buffRound,WuGong_hits,wugong_specialNumber) 
values (2,"斗转星移","将对手的内力和招数进行随意转移的武功。（你的运势提高30%，持续3回合）",4,30,3,0,0); 

insert WuGong (WuGong_type,WuGong_name,WuGong_remark,WuGong_buffName,WuGong_buffPower,WuGong_buffRound,WuGong_hits,wugong_specialNumber) 
values (5,"紫霞神功","华山派称誉江湖的上乘内功。（你的闪避永久增加5%）",6,5,0,0,0); 
 
insert WuGong (WuGong_type,WuGong_name,WuGong_remark,WuGong_buffName,WuGong_buffPower,WuGong_buffRound,WuGong_hits,wugong_specialNumber) 
values (5,"九阴真经","所有上乘武学的原理几乎都不脱离九阴真经的内容，可说是武学的百科全书。（你的攻击永久提高1.5倍）",1,150,0,0,0); 

insert WuGong (WuGong_type,WuGong_name,WuGong_remark,WuGong_buffName,WuGong_buffPower,WuGong_buffRound,WuGong_hits,wugong_specialNumber) 
values (5,"易筋经","天竺和尚达摩留下的两卷秘经之一。（你的防御永久提高1.5倍）",2,150,0,0,0); 

-- 物品表
--  create table Goods
-- (
-- 			goods_id int auto_increment not null PRIMARY key,   
-- 			goods_name varchar(20) not null,
-- 			goods_remark varchar(100) not null,
-- 			goods_type int not null,
-- 			goods_buffName int not null,
-- 			goods_buffPower int not null

-- )engine=innodb default charset=UTF8;

-- 物品表新增数据
-- insert Goods (goods_name,goods_remark,goods_type,goods_buffName,goods_buffPower) values ("大力丸","接受你无法理解的力量！",2 , 1 ,120 ) ;
-- insert Goods (goods_name,goods_remark,goods_type,goods_buffName,goods_buffPower) values ("敏捷丹","面对疾风吧！",2 ,3 ,120 ) ;

-- 背包表
-- create table BackPack
-- (
-- 		backpack_id int auto_increment not null PRIMARY key,  
-- 			player_id int not null,
-- 			foreign key (player_id) references Player(player_id),
-- 			goods_id int not null,
-- 			foreign key (goods_id) references Goods(goods_id),
-- 			backpack_GoodsType int not null,
-- 			backpack_GoodsNumber int not null ,
-- 			backpack_GoodsState int not null


--  )ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 帮会玩家表
-- create table TeamPlayer
-- (
-- 			teamplayer_id int auto_increment not null PRIMARY key,  
-- 			team_id int not null,
-- 			foreign key (team_id) references Team(team_id),
-- 			player_id int not null,
-- 			foreign key (player_id) references Player(player_id),
-- 			teamplayer_contribution int not null,
-- 			teamplayer_job int not null 
-- 
-- )ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 玩家关系表
-- create table PlayerRelationship
-- (
-- 			playerrelationship_id int auto_increment not null PRIMARY key,
-- 			playerrelationship_playerId int not null,
-- 			playerrelationship_beplayerId int not null,
-- 			playerrelationship_relationship int not null,
-- 			playerrelationship_time varchar(50) not null

-- )ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 帮会职务表
-- create table TeamJob
-- (
-- 			teamjob_id int auto_increment not null PRIMARY key,
-- 			team_id int not null,
-- 			foreign key (team_id) references Team(team_id),
-- 			teamjob_oneName 	varchar(5) not null,
-- 			teamjob_twoName 	varchar(5) not null,
-- 			teamjob_threeName varchar(5) not null,
-- 			teamjob_fourName 	varchar(5) not null,
-- 			teamjob_fiveName 	varchar(5) not null
-- 
-- )ENGINE=InnoDB DEFAULT CHARSET=UTF8;
 
-- 用户表
create table user 
(
			user_id int auto_increment not null PRIMARY key, 
			user_name varchar(15) not null,
			user_password varchar(15) not null,
			player_id  int not null,
			user_remark varchar(100) not null,
			user_state int not null,
			user_face varchar(100)
			

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 用户表新增数据
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★阿青★",52052052020,1,"天……天下竟有着……这样的美女！",1,10);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★飞蓬★",52052052020,2,"夕瑶……",1,8);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★重楼★",52052052020,3,"相见不如不见，有情还似无情，我知道她平安就够了…",1,9);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★李寻欢★",52052052020,4,"只愿，不负如来不负卿",1,5);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★郭靖★",52052052020,5,"为国为民，侠之大者。",1,2);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★欧阳锋★",52052052020,6,"西毒",1,4);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★邀月★",52052052020,7,"",1,12);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★李逍遥★",52052052020,8,"仗剑江湖梦已远，浪漫惟有奇侠传。",1,1);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★赵灵儿★",52052052020,9,"逍遥哥哥……",1,17);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★木道人★",52052052020,10,"",1,7);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★陆小凤★",52052052020,11,"因为我喜欢跟你在一起。",1,8);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★花满楼★",52052052020,12,"陆兄，你不要乱开玩笑……",1,1);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★叶孤城★",52052052020,13,"",1,6);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★孟星魂★",52052052020,14,"。。。",1,4);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★律香川★",52052052020,15,"",1,3);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★林诗音★",52052052020,16,"",1,18);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★姜风★",52052052020,17,"别来我的绝情谷闹事啊！我先去找叶小汐玩儿了~",1,2);  
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★叶汐★",52052052020,18,"",1,11);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★欧阳辰★",52052052020,19,"我们，才是真正的正道。",1,5);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★黯邪★",52052052020,20,"武林萌那些伪君子，呵呵。",1,4);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★祈灵★",52052052020,21,"武林盟和邪教的争斗，其实毫无意义。",1,15);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★墨青玄★",52052052020,22,"寒修这家伙，真不够意思。",1,1);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★百里寒修★",52052052020,23,"",1,2);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★祈玉★",52052052020,24,"想去宫外玩儿。。",1,13);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★行走江湖的少年★",52052052020,25,"总有一天，我也会成为一代大侠~",1,5);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★机智的少女★",52052052020,26,"看什么看！",1,3);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★小巷里的流浪者★",52052052020,27,"。。。",1,15);
insert user(user_name,user_password,player_id,user_remark,user_state,user_face) values("★练习用的木头人★",52052052020,28,"。。。",1,5);

-- 留言版表
create table Message
(
			message_id int auto_increment not null PRIMARY key,  
			user_id  int not null,  
			beuser_id  int not null,
			message_content varchar(100) not null, 
			message_time varchar(50) not null

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 动态表
create table Action
(
			action_id int auto_increment not null PRIMARY key,  
			user_id int not null,
			foreign key (user_id) references User(user_id),
			action_time varchar(50) not null,
			action_content varchar(100) not null,
			action_number int not null

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 学习情况表
create table studyInfo
(
			studyInfo_id int auto_increment not null PRIMARY key, 
			user_id  int not null,
			foreign key (user_id) references User(user_id),
			studyInfo_time varchar(50) not null,
			studyInfo_content varchar(300) not null

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 日常表
create table daily
(
			daily_id int auto_increment not null PRIMARY key, 
			daily_date varchar(50) not null,
			daily_power  int not null,
			daily_camp1  int not null,
			daily_camp2  int not null,
			daily_camp3  int not null

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
insert daily(daily_date,daily_power,daily_camp1,daily_camp2,daily_camp3)
values ("123",0,0,0,0);

-- 名句表
create table sentence
(
	sentence_id int auto_increment not null PRIMARY key,
	sentence_content varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 新增名句
insert sentence (sentence_content) values ("每一个成功者都有一个开始。勇于开始，才能找到成功的路。");
insert sentence (sentence_content) values ("任何的限制，都是从自己的内心开始的。");
insert sentence (sentence_content) values ("古之成大事者，不唯有超世之才，亦必有坚韧不拔之志也。");
insert sentence (sentence_content) values ("世界上那些最容易的事情中，拖延时间最不费力。");
insert sentence (sentence_content) values ("你所过的每一个今天，都将是余生最年轻的一天。");
insert sentence (sentence_content) values ("再长的路，一步步也能走完，再短的路，不迈开双脚也无法到达。");
insert sentence (sentence_content) values ("世界会向那些有目标和远见的人让路。");
insert sentence (sentence_content) values ("有事者，事竟成；破釜沉舟，百二秦关终归楚；苦心人，天不负；卧薪尝胆，三千越甲可吞吴。");
insert sentence (sentence_content) values ("这个社会，是赢家通吃，输者一无所有，社会，永远都是只以成败论英雄。");
insert sentence (sentence_content) values ("强者之所以强，是因为他与别人共处逆境时，别人失去了信心，他却下决心实现自己的目标。");
insert sentence (sentence_content) values ("一个年轻人，如果三年的时间里，没有任何想法，他这一生，就基本这个样子，没有多大改变了。");
insert sentence (sentence_content) values ("勤奋是你生命的密码，能译出你一部壮丽的史诗。");
insert sentence (sentence_content) values ("不管多么险峻的高山，总会为不畏艰难的人留下一条攀登的路。");
insert sentence (sentence_content) values ("机会只对进取有为的人开放，庸人永远无法光顾。");
insert sentence (sentence_content) values ("怠惰是贫穷的制造厂。");
insert sentence (sentence_content) values ("最好的节约是珍惜时间，最大的浪费是虚度年华。");
insert sentence (sentence_content) values ("承认自己的平凡，然后用千百倍的努力来弥补平凡。");
insert sentence (sentence_content) values ("有福之人是那些抱有美好的企盼从而灵魂得到真正满足的人。");
insert sentence (sentence_content) values ("有不少人决心去改造这个世界，但实际上有几个人能真正改造自己。");
insert sentence (sentence_content) values ("强大的力量如果没有方向和着力点，那又怎么能击破障碍。");
insert sentence (sentence_content) values ("活着一天，就是有福气，就该珍惜。当我哭泣我没有鞋子穿的时候，我发现有人却没有脚。");
insert sentence (sentence_content) values ("感谢上苍我所拥有的，感谢上苍我所没有的。");
insert sentence (sentence_content) values ("心有多大，舞台就有多大。思考的越多，得到的越多。因为思考可以释放能量。");
insert sentence (sentence_content) values ("伟大的梦想让成就随之成长，渺小的希望让你永落人群之后。");
insert sentence (sentence_content) values ("我们能做到的，比想象的更多。");
insert sentence (sentence_content) values ("多数人都拥有自己不了解的能力和机会，都有可能做到未曾梦想的事情。");
insert sentence (sentence_content) values ("战斗！到最后一滴血！！！");
insert sentence (sentence_content) values ("环境不会改变，解决之道在于改变自己。");
insert sentence (sentence_content) values ("只要路是对的，就不怕路远。");
insert sentence (sentence_content) values ("回避现实的人，未来将更不理想。");
insert sentence (sentence_content) values ("金字塔是用一块块的石头堆砌而成的。");
insert sentence (sentence_content) values ("凡事皆有终结，因此，耐心是赢得成功的一种手段。");
insert sentence (sentence_content) values ("成功的秘诀端赖坚毅的决心。");
insert sentence (sentence_content) values ("成功并非重要的事，重要的是努力。");
insert sentence (sentence_content) values ("我跌倒过。我在嘲笑声中站起来，虽然衣服脏了，但那是暂时的，它可以洗净。");
insert sentence (sentence_content) values ("第一个青春是上帝给的；第二个青春是靠自己努力的。");
insert sentence (sentence_content) values ("每天醒来，敲醒自己的不是钟声，而是梦想。");
insert sentence (sentence_content) values ("每个人都会累，没人能为你承担所有悲伤，人总有一段时间要学会自己长大。");
insert sentence (sentence_content) values ("没有一种不通过蔑视、忍受和奋斗就可以征服的命运。");
insert sentence (sentence_content) values ("昨天下了雨，今天刮了风，明天太阳就出来了。");
insert sentence (sentence_content) values ("微笑是我们心灵的最真诚倾诉，是在困难面前最好的良药。");
insert sentence (sentence_content) values ("宝剑锋从磨砺出，梅花香自苦寒来。");
insert sentence (sentence_content) values ("吃得苦中苦，方为人上人。");
insert sentence (sentence_content) values ("不怕路长，只怕志短。");
insert sentence (sentence_content) values ("一寸光阴一寸金，寸金难买寸光阴。");
insert sentence (sentence_content) values ("不经一番寒彻骨，怎得梅花扑鼻香？");
insert sentence (sentence_content) values ("绳锯木断，水滴石穿。");
insert sentence (sentence_content) values ("书山有路勤为径，学海无涯苦作舟。");
insert sentence (sentence_content) values ("冰冻三尺，非一日之寒。");
insert sentence (sentence_content) values ("人生难得几回搏，此时不搏何时搏。");
insert sentence (sentence_content) values ("并非所有流浪者，都迷失了自我。");
insert sentence (sentence_content) values ("在你内心深处，还有无穷的潜力，有一天当你回首看时，你就会知道这绝对是真的。");
insert sentence (sentence_content) values ("Keep on going never give up."); 
insert sentence (sentence_content) values ("Believe in yourself.");
insert sentence (sentence_content) values ("Action speak louder than words.");
insert sentence (sentence_content) values ("Winners do what losers don't want to do.");
insert sentence (sentence_content) values ("Whatever is worth doing is worth doing well.");
insert sentence (sentence_content) values ("Zero in your target,and go for it.");
insert sentence (sentence_content) values ("Take control of your own desting.");
insert sentence (sentence_content) values ("Live well, love lots, and laugh often.");
insert sentence (sentence_content) values ("Quitters never win and winners never quit."); 
insert sentence (sentence_content) values ("Every man is his own worst enemy.");
insert sentence (sentence_content) values ("From small beginnings comes great things. ");
insert sentence (sentence_content) values ("Birth is much, but breeding is more.");
insert sentence (sentence_content) values ("Misfortunes tell us what fortune is.");
insert sentence (sentence_content) values ("Constant dropping wears the stone. ");

-- 公告表
create table notice
(
	notice_id int auto_increment not null PRIMARY key,
	notice_content varchar(50)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

-- 公告表新增
insert notice (notice_content) values ("公告:趣学习，去超越~ o(*≧▽≦)ツ ");
insert notice (notice_content) values ("公告:趣学习，去超越~ o(*≧▽≦)ツ "); 
insert notice (notice_content) values ("Tips:据说，欢迎界面有另一个世界的入口。 ");
insert notice (notice_content) values ("Tips:名字中带有★的玩家为npc。 ");
insert notice (notice_content) values ("Tips:每天发表学习情况可以获得大量经验。 ");
insert notice (notice_content) values ("Tips:没有人可以在绝情谷杀你，除非他的实力在谷主之上。 ");
insert notice (notice_content) values ("Tips:得饶人处且饶人，当然，如果你的目的是他的武器…… ");
insert notice (notice_content) values ("Tips:你想成为仙剑奇侠还是乱世枭雄？");
insert notice (notice_content) values ("Tips:运势是非常重要的属性。");
insert notice (notice_content) values ("Tips:战斗力并不能决定一切。");
insert notice (notice_content) values ("Tips:击败首页排行榜上的玩家，将获得额外的奖励。");
insert notice (notice_content) values ("Tips:每次升级都将获得修炼点，合理分配它们。");
insert notice (notice_content) values ("Tips:在你的暴击值超过50之前，每天发表学习情况可以增加1%的暴击值。");
insert notice (notice_content) values ("Tips:击败首页榜单上的人物可以获得3倍的经验、修为。");
insert notice (notice_content) values ("Tips:修为太少是无法转化为修炼点的。");
insert notice (notice_content) values ("Tips:每次战斗至多获得10万修为。");
insert notice (notice_content) values ("Tips:战斗力并不能说明一切。");
insert notice (notice_content) values ("公告:趣学习，去超越~ o(*≧▽≦)ツ ");
insert notice (notice_content) values ("公告:趣学习，去超越~ o(*≧▽≦)ツ "); 

-- 管理员表
create table manager
(
	manager_id int auto_increment not null PRIMARY key,
	manager_name varchar(10) not null,
	manager_password varchar(20)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;
-- 管理员新增
insert manager (manager_name,manager_password) values ("Jason","Jason");