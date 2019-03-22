package zju.xyb.trade.user.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zju.xyb.trade.common.api.IUserApi;
import zju.xyb.trade.common.protocol.user.QueryUserReq;
import zju.xyb.trade.common.protocol.user.QueryUserRes;
import zju.xyb.trade.user.service.UserServiceImpl;

@Controller
public class UserApiImpl implements IUserApi{

    @Autowired
    private UserServiceImpl userService;

    public QueryUserRes queryUserById(QueryUserReq queryUserReq) {
        return null;
    }

    @PostMapping(value = "/queryUserById")
    @ResponseBody
    public QueryUserRes queryUserById(String id) {
        QueryUserReq queryUserReq = new QueryUserReq();
        queryUserReq.setId(Integer.valueOf(id));
        QueryUserRes queryUserRes = userService.queryUserById(queryUserReq);
        System.out.println(queryUserRes.toString());
        return queryUserRes;
    }
}
