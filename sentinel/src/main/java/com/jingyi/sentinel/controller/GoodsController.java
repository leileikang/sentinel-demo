package com.jingyi.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.jingyi.sentinel.service.GoodsQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author leilei
 */
@Controller
@RequestMapping("goods")
public class GoodsController {

    private GoodsQueryService goodsQueryService;

    @Autowired
    public GoodsController(GoodsQueryService goodsQueryService) {
        this.goodsQueryService = goodsQueryService;
    }

    /**
     * 代码不加任何限流 熔断
     * @return
     */
    @RequestMapping("/test")
    @ResponseBody
    @SentinelResource("test")
    public String test() {
        return "test";
    }

    @RequestMapping("/queryGoodsInfo")
    @ResponseBody
    public String queryGoodsInfo(@RequestParam("spuId") String spuId) {
        String res = goodsQueryService.queryGoodsInfo(spuId);
        return res;
    }
}
