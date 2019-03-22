package zju.xyb.trade.user.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zju.xyb.trade.common.constant.RetEnum;
import zju.xyb.trade.common.protocol.user.QueryUserReq;
import zju.xyb.trade.common.protocol.user.QueryUserRes;
import zju.xyb.trade.common.service.IUserService;
import zju.xyb.trade.dao.entity.TradeUser;
import zju.xyb.trade.dao.mapper.TradeUserMapper;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired(required = false)
    private TradeUserMapper tradeUserMapper;

    public QueryUserRes queryUserById(QueryUserReq queryUserReq) {
        QueryUserRes queryUserRes = new QueryUserRes();
        try{
            if(queryUserReq == null || queryUserReq.getId() == null) {
                throw new RuntimeException("查询用户请求参数不正确");
            }
            TradeUser tradeUser = tradeUserMapper.selectByPrimaryKey(queryUserReq.getId());
            if (tradeUser != null) {
                queryUserRes.setRetCode(RetEnum.SUCCESS.getCode());
                queryUserRes.setRetInfo(RetEnum.SUCCESS.getDesc());
                BeanUtils.copyProperties(tradeUser,queryUserRes);
            } else {
                throw new RuntimeException("未查询到该用户");
            }
        } catch (Exception e) {
            queryUserRes.setRetCode(RetEnum.FAILED.getCode());
            queryUserRes.setRetInfo(RetEnum.FAILED.getDesc());
        }

        return queryUserRes;
    }
}
