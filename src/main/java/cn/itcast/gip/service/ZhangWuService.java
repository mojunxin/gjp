package cn.itcast.gip.service;
/*
业务层
接受上一层 控制层controller
经过计算 传递给dao层  操作数据库
调用dao层中的类 类的成员位置 创建Dao类得对象
 */

import cn.itcast.gip.dao.ZhangWuDao;
import cn.itcast.gip.domain.ZhangWu;

import java.util.List;

public class ZhangWuService {
    private ZhangWuDao dao = new ZhangWuDao();

    /*
    定义方法用于添加账务
     */
    public void addZhangWu(ZhangWu zw){
        dao.addZhangWu(zw);
    }

    /*
    定义方法 实现所有查询得方法
    此方法由控制层调用 去调用dao 方法
     */
    public List<ZhangWu> selectAll(){
       return dao.selectAll();
    }

    public List<ZhangWu> select(String startData,String endData){
        return dao.select(startData,endData);
    }

    public void editZhangWu(ZhangWu zw) {
        dao.editZhangWu(zw);
    }

    public void deleteZhangWu(int zwid) {
        dao.deleteZhangWu(zwid);
    }
}














