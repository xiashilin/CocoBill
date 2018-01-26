package com.copasso.cocobill.api;


import com.copasso.cocobill.bean.*;
import com.copasso.cocobill.common.HttpConfig;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by zhouas666 on 2018/1/19.
 */

public interface APIService {

    /**
     * 用户登陆
     *
     * @param username
     * @param password
     * @return
     */
    @GET(HttpConfig.USER_LOGIN)
    Observable<UserBean> login(@Query("username") String username, @Query("password") String password);

    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @param mail
     * @return
     */
    @GET(HttpConfig.USER_SIGN)
    Observable<UserBean> signup(@Query("username") String username, @Query("password") String password
            , @Query("mail") String mail);

    /**
     * 每月账单详情
     *
     * @param id
     * @param year
     * @param month
     * @return
     */
    @GET(HttpConfig.BILL_MONTH_DETIAL)
    Observable<MonthDetailBean> getMonthDetial(@Path("id") String id, @Path("year") String year
            , @Path("month") String month);

    /**
     * 每月账单分类
     *
     * @param id
     * @param year
     * @param month
     * @return
     */
    @GET(HttpConfig.BILL_MONTH_CHART)
    Observable<MonthChartBean> getMonthChart(@Path("id") String id, @Path("year") String year
            , @Path("month") String month);

    /**
     * 每月账户统计
     *
     * @param id
     * @param year
     * @param month
     * @return
     */
    @GET(HttpConfig.BILL_MONTH_CARD)
    Observable<MonthAccountBean> getMonthAccount(@Path("id") String id, @Path("year") String year
            , @Path("month") String month);

    /**
     * 添加账单
     *
     * @param userid
     * @param sortid
     * @param payid
     * @param cost
     * @param crdate
     * @param content
     * @param income
     * @return
     */
    @GET(HttpConfig.BILL_ADD)
    Observable<BaseBean> addBill(@Query("userid") int userid, @Query("sortid") int sortid
            , @Query("payid") int payid, @Query("cost") Float cost
            , @Query("content") String content, @Query("crdate") String crdate, @Query("income") boolean income);


}
