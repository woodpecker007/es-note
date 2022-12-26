package com.aurora.es;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private ProductDao productDao;

    @Test
    public void testCreateIndex() {
        System.out.println("创建索引");
    }

    @Test
    public void deleteIndex() {
        boolean result = elasticsearchRestTemplate.indexOps(IndexCoordinates.of("product")).delete();
        System.out.println("删除索引：" + result);
    }

    @Test
    public void save() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("菠萝手机");
        product.setCategory("手机");
        product.setPrice(19999.0);
        product.setImages("http://localhost");
        productDao.save(product);
    }

    @Test
    public void findById() {
        Product product = productDao.findById(1L).get();
        System.out.println(product);
    }

}
