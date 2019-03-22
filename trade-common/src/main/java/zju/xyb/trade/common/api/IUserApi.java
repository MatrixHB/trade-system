package zju.xyb.trade.common.api;

import zju.xyb.trade.common.protocol.user.QueryUserReq;
import zju.xyb.trade.common.protocol.user.QueryUserRes;

public interface IUserApi {

     public QueryUserRes queryUserById(QueryUserReq queryUserReq);
}
