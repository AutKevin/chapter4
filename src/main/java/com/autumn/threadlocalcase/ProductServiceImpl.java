package com.autumn.threadlocalcase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: ProductServiceImpl
 * @description: ProductService实现类
 * @author: qiuyu
 * @create: 2018-11-28 06:04
 **/
public class ProductServiceImpl implements ProductService{
    private static final String UPDATE_PRODUCT_SQL = "update product set price = ? where id = ?";
    private static final String INSERT_LOG_SQL = "insert into log(createid,description) value (?,?)";

    /*更新价格并插入到log表中*/
    @Override
    public void updateProductPrice(long id, int price) {
        try {
            //获取连接
            Connection conn = DBUtil.getConnection();
            conn.setAutoCommit(false);   //关闭自动提交事物（开启事物）

            //执行操作
            updateProduct(conn,UPDATE_PRODUCT_SQL,id,price);   //更新产品
            insertLog(conn,INSERT_LOG_SQL,"create product.");    //插入日志

            //提交事物
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection();  //关闭连接
        }
    }

    /*更新价格*/
    private void updateProduct(Connection conn,String updateProdutSQL,long productId,int productPrice) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(updateProdutSQL);
        pstmt.setInt(1,productPrice);
        pstmt.setLong(2,productId);
        int rows = pstmt.executeUpdate();
        if (rows != 0){
            System.out.println("Update Product Success！");
        }
    }

    /*插入到Log表*/
    private void insertLog(Connection conn,String insertLogSQL,String logDescription) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement(insertLogSQL);
        pstmt.setString(1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        pstmt.setString(2,logDescription);
        int rows = pstmt.executeUpdate();
        if (rows != 0){
            System.out.println("Insert log Success！");
        }
    }

    public static void main(String[] args) {
        /*调用*/
        /*ProductService service = new ProductServiceImpl();
        service.updateProductPrice(1,3000);*/
        /*多线程调用*/
        for (int i=1;i<10;i++){
            ProductService service = new ProductServiceImpl();
            ClientThread thread = new ClientThread(service);
            thread.start();
        }
    }
}
