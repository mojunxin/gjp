package cn.itcast.gip.dao;

import cn.itcast.gip.domain.ZhangWu;
import cn.itcast.gip.tools.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ZhangWuDao {
    private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());

    /*
   定义方法用于添加账务
    */
    public void addZhangWu(ZhangWu zw){
        //拼写添加数据的sql
        String sql = "INSERT INTO gjp_zhangwu(flname,money,zhanghu,createtime,description)VALUES(?,?,?,?,?)";
        Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),zw.getCreatetime(),zw.getDescription()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("添加失败");
        }
    }



    public List<ZhangWu> select(String startData,String endData){
        List<ZhangWu> list = null;
        try {
            String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
            Object[] params = {startData,endData};
            list = qr.query(sql, new BeanListHandler<>(ZhangWu.class), params);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("查询失败");
        }
        return list;
    }


    /*
     * 定义方法,查询数据库,获取所有的账务数据
     * 方法,由业务层调用
     * 结果集,将所有的账务数据,存储到Bean对象中,存储到集合中
     */
    public List<ZhangWu> selectAll(){
        String sql = "SELECT * FROM gjp_zhangwu";
        //调用方法qr
        try {
            List<ZhangWu> list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
            return list;
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("查询失败");
        }
    }
    //实现编辑功能
    //
    public void editZhangWu(ZhangWu zw) {
        //更新数据的sql语句
        String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
        Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhangHu(),
                zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {

            System.out.println(e);
            throw new RuntimeException("编辑失败");
        }
    }
    //删除功能
    public void deleteZhangWu(int zwid) {
        String sql = "DELETE FROM gjp_zhangwu WHERE zwid = ?";
        try {
            qr.update(sql,zwid);
        } catch (SQLException e) {
            System.out.println(e);
            throw new RuntimeException("删除失败");
        }
    }
}



















