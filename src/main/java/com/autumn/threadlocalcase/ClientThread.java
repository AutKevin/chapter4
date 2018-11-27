package com.autumn.threadlocalcase;
/**
 * Created by Administrator on 2018/11/28.
 */

/**
 * @program: ClientThread
 * @description: 线程类
 * @author: qiuyu
 * @create: 2018-11-28 07:16
 **/
public class ClientThread extends Thread {
    private ProductService productService;

    public ClientThread(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        productService.updateProductPrice(1,3000);
    }
}
