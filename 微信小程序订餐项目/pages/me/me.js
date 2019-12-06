// pages/me/me.js
var that = this;
Page({

  /**
   * 页面的初始数据
   */
  data: {
      
  },
    onLoad: function (options) {
        //获取用户的信息，并且存在该页面数据中
        var userInfo = wx.getStorageSync('userInfo');
        this.setData({
            userInfo: userInfo
        })
    },

//订单
    findOrder:function(){
        //跳转到订单页面(跳转到非tabBar的页面)
        wx.navigateTo({
            url: '/pages/confirmOrder/confirmOrder',
        })
    },
//地址
    findAddress:function(){
        //关闭当前页面，跳转页面。。。。最好多用redirectTo
        wx.redirectTo({
            url: '/pages/address/address',
        })
    },
//评论区
    findComment:function(){
        //跳转到订单页面(跳转到非tabBar的页面)
        wx.navigateTo({
            url: '/pages/comment/comment',
        })
    }
    
})