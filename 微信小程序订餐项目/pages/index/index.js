//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
    //判断小程序的API，回调，参数，组件等是否在当前版本可用。 ****必须存在
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
    isHide: false
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: '../logs/logs'
    })
  },

    onLoad: function () {
        var that = this;
        // 查看是否授权
        wx.getSetting({
            success: function (res) {
                if (res.authSetting['scope.userInfo']) {
                    wx.getUserInfo({
                        success: function (res) {
                            wx.login({
                                success: function(res) {
                                    // 获取到用户的 code 之后：res.code
                                    console.log("用户的code:" + res.code);
                                    // 或者可以直接使用微信的提供的接口直接获取 openid ，方法如下：
                                    wx.request({
                                        // 自行补上自己的 APPID 和 SECRET
                                        url: 'https://api.weixin.qq.com/sns/jscode2session?appid=wx07c9c56f1237ef16&secret=482091bd52ef10937740c0492f3d1b46&js_code=' + res.code + '&grant_type=authorization_code',
                                        method:'GET',
                                        header: { 'content-type': 'application/json' },
                                        success: function(res){
                                            console.log(":" + res.data.openid);
                                        }
                                    });
                                }
                            });
                        }
                    });
                    //提示
                    wx.showLoading({
                        title: '加载中',
                    })
                    //如果该用户授权登陆过了，就跳转
                    that.tiaozhuan();
                } else {
                    // 用户没有授权
                    // 改变 isHide 的值，显示授权页面
                    that.setData({
                        isHide: true
                    });
                }
            }
        });
    },

    bindGetUserInfo: function (e) {
        var that = this;
        var userinfo = e.detail.userInfo;
        if (userinfo) {
            //用户按了允许授权按钮
            var that = this;
            // 获取到用户的信息了，打印到控制台上看下
            console.log(userinfo);
            //授权成功后,通过改变 isHide 的值，让实现页面显示出来，把授权页面隐藏起来
            that.setData({
                isHide: false,
                userInfo: userinfo,
            });
            
            //将用户信息保存在storage中
            wx.setStorage({
                key: 'userInfo',
                data: userinfo,
            })

            //将用户保存至数据库
            wx.request({
                url: 'http://localhost:8080/WXdemo/saveUserinfo',  //本地服务器地址
                data: {
                    username:userinfo.nickName,
                    usersex: userinfo.gender,
                    userpic:userinfo.avatarUrl,
                    userprovince:userinfo.province,
                    },
                method: 'post',
                header: {
                    'content-type': 'application/x-www-form-urlencoded'
                },
                success: function (res) { }
            })

            //跳转页面
            wx.switchTab({
                url: '../market/market',
            })
        } else {
            //用户按了拒绝按钮
            wx.showModal({
                title: '警告',
                content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!!!',
                showCancel: false,
                confirmText: '返回授权',
                success: function (res) {
                    // 用户没有授权成功，不需要改变 isHide 的值
                    if (res.confirm) {
                        console.log('用户点击了“返回授权”');
                    }
                }
            });
        }
    },

    tiaozhuan:function(){
        //提示用户
        wx.showLoading({
            title: '加载中',
        })
        wx.switchTab({
            url: '../market/market',
        })
    }
  
    
})
