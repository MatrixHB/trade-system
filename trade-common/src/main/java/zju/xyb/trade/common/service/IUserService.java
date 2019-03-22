package zju.xyb.trade.common.service;

import zju.xyb.trade.common.protocol.user.QueryUserReq;
import zju.xyb.trade.common.protocol.user.QueryUserRes;

public interface IUserService {

    public QueryUserRes queryUserById(QueryUserReq queryUserReq);
}
