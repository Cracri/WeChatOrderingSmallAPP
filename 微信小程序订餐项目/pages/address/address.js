//index.js
//获取应用实例
const app = getApp();
var QQMapWX = require('../../utils/qqmap-wx-jssdk.min.js');
var qqmapsdk;
Page({
    data: {
        province: '',
        city: '',
        latitude: '',
        longitude: '',
        address: '',
    },
    onLoad: function () {
        qqmapsdk = new QQMapWX({
            key: 'KWMBZ-6646X-DEW4R-Z6GBL-S56DQ-YYBH4' //这里自己的key秘钥进行填充
        });

        //获取用户的信息，并且存在该页面数据中
        var userInfo = wx.getStorageSync('userInfo');
        this.setData({
            userInfo: userInfo,
            username:userInfo.nickName,
        })

    },
    onShow: function () {
        var that = this;

        //查询用户所具有的详细地址
        wx.request({
            url: 'http://localhost:8080/WXdemo/findDetailAddress',
            data: {
                username:that.data.username,
            },
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded',
            },
            success: function (res) {
                // console.log(res.data);
                if(res.data === "null"){
                    
                }else{
                    that.setData({
                        addressList:res.data,
                    })
                }
            }
        })


    },

    //返回我的页面
    returnMeWxml:function(){
        //关闭所有页面，打开到应用内的某个页面
        wx.reLaunch({
            url: '/pages/me/me',
        })
    },

    //添加收获地址
    insertAddress:function(){
        //跳转到添加页面(跳转到非tabBar的页面)
        wx.navigateTo({
            url: '/pages/insertAddress/insertAddress',
        })
    },

    //返回上一个地址，并且传入选择的地址
    returnCartWxml:function(e){
        var index = e.currentTarget.dataset.index;
        //获取地址List
        var addressList = this.data.addressList;
        //获取被选中地址
        var chooseAddress = addressList[index];
        /**为上一个Cart 页面中的 地址信息赋值**/
        //获取页面栈
        var pages = getCurrentPages();
        //如果只有当前页面，就不触发。
        if(pages.length <= 1){
            return false;
        }else{          
            var prevPage = pages[pages.length - 2];  //返回上一个页面
            //直接调用上一个页面对象的setData()方法，把数据存到上一个页面中去
            prevPage.setData({
                consignee: chooseAddress.consignee,
                telNumber: chooseAddress.telNumber,
                provinceName: chooseAddress.provinceName,
                cityName: chooseAddress.cityName,
                districtName: chooseAddress.districtName,
                detailInfo: chooseAddress.detailInfo
            });
        }

        //返回上一个界面
        wx.navigateBack({
            
        })
    },

    delThisAddress:function(e){
        var that  = this;
        //获取到用户信息
        var username = this.data.username;
        //获取到this地址
        var id = e.currentTarget.dataset.id;

        wx.showModal({
            title: '提示',
            content: '确定要删除吗?',
            success:function(res){
                if(res.confirm){
                    //删除该id
                    wx.request({
                        url: 'http://localhost:8080/WXdemo/delThisAddress',
                        data: {
                            username: username,
                            id: id
                        },
                        header: { 'content-type': 'application/x-www-form-urlencoded' },
                        method: 'post',
                        dataType: 'text',
                        success: function (res) {
                            if (res.data === "ok") {
                                //刷新数据
                                that.onShow();
                            }
                        },
                    })
                }
            }
        })

    }

    
})