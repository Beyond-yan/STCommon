package com.beyond.service;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.beyond.dao.GoodsDao;
import com.beyond.entity.Goods;
import org.springframework.stereotype.Service;

@Service
public class GoodsService extends ServiceImpl<GoodsDao , Goods> {
}
