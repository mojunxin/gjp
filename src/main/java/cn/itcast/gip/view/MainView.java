package cn.itcast.gip.view;

import cn.itcast.gip.controller.ZhangWuController;
import cn.itcast.gip.domain.ZhangWu;

import java.util.List;
import java.util.Scanner;

/*
视图层 用户看到和操作得界面
 */
public class MainView {
    private ZhangWuController controller = new ZhangWuController();
    Scanner scanner = new Scanner(System.in);
    /*
    用于用户操作选项
     */
    public void run(){
        while (true){
            System.out.println("---------------管家婆家庭记账软件---------------");
            System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
            System.out.println("请输入要操作的功能序号[1-5]:");
            //选择键盘输入
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    //1.添加账务
                    addZhangWu();
                    break;
                case 2:
                    //2.编辑账务
                    editZhangWu();
                    break;
                case 3:
                    //3.删除账务
                    deleteZhangWu();
                    break;
                case 4:
                    selectZhangWu();
                    //4.查询账务
                    break;
                case 5:
                    //5.退出系统
                    System.exit(0);
                    break;
            }
        }
    }

    /*
    用于删除账务
     */
    public void deleteZhangWu(){
        selectAll();
        System.out.println("选择需要删除的序号");
        int zwid = scanner.nextInt();
        //调用控制层
        controller.deleteZhangWu(zwid);
    }
    /*
    用户的编辑
     */
    public void editZhangWu(){
        selectAll();
        System.out.println("请选择查询项目");
        System.out.println("输入ID：");
        int zwid = scanner.nextInt();
        System.out.println("输入分类名称：");
        String flname = scanner.next();
        System.out.println("输入金额：");
        double money = scanner.nextDouble();
        System.out.println("输入账户：");
        String zhanghu = scanner.next();
        System.out.println("输入日期 格式xxxx-xx-xx：");
        String createtime = scanner.next();
        System.out.println("输入具体描述：");
        String description = scanner.next();
        ZhangWu zw = new ZhangWu(zwid,flname,money,zhanghu,createtime,description);
        controller.editZhangWu(zw);
        System.out.println("编辑成功！！");
    }

    /*
    用于用户添加的方法
     */
    public void addZhangWu(){
        System.out.println("选择添加账务的功能，请输入一下功能");
        System.out.println("输入分类名称");
        String flname = scanner.next();
        System.out.println("输入金额");
        double money = scanner.nextDouble();
        System.out.println("输入账户");
        String zhanghu = scanner.next();
        System.out.println("输入日期 格式xxxx-xx-xx");
        String createtime = scanner.next();
        System.out.println("请输入具体描述");
        String description = scanner.next();
        //将接收到的数据 调用controller层的方法中去
        ZhangWu zw = new ZhangWu(0,flname,money,zhanghu,createtime,description);
        controller.addZhangWu(zw);
        System.out.println("添加成功！！！");
    }

    /*
    用于用户查询得方法  部分查询还是全部查询
     */
    public void selectZhangWu(){
        System.out.println("1.查询所有　2.按条件查询");
        int choose = scanner.nextInt();
        switch (choose){
            //查询所有得方法
            case 1:
                selectAll();
                break;
            //部分查询
            case 2:
                select();
                break;
        }
    }
    public void select() {
        System.out.println("请输入日期格式：xxxx-xx-xx");
        System.out.println("请输入开始日期：");
        String starData = scanner.next();
        System.out.println("请输入结束日期：");
        String endData = scanner.next();
        //调用controller层的方法 传递日期  获取查询结果
        List<ZhangWu> list = controller.select(starData, endData);
        if (list==null){
            System.out.println("没有查询数据");
        }else {
            print(list);
        }

    }
    public void selectAll() {
        //调用控制层得方法 查询所有得财务数据
        List<ZhangWu> list =controller.selectAll();
        if (list==null){
            System.out.println("没有查询数据");
        }else {
            print(list);
        }
    }
    public void print(List<ZhangWu> list){
        //输出表头
        System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t说明");
        //遍历集合
        for (ZhangWu zw : list) {
            System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getZhangHu()+"\t\t"+
                    zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription());
        }
    }
}
