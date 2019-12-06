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
        consignee:''
    },
    onLoad: function () {
        qqmapsdk = new QQMapWX({
            key: 'KWMBZ-6646X-DEW4R-Z6GBL-S56DQ-YYBH4' //这里自己的key秘钥进行填充
        });

        //获取用户的信息，并且存在该页面数据中
        var userInfo = wx.getStorageSync('userInfo');
        this.setData({
            userInfo: userInfo
        })
    },
    onShow: function () {
        let vm = this;
        vm.getUserLocation();
    },

    getUserLocation: function () {
        let vm = this;
        wx.getSetting({
            success: (res) => {
                console.log(JSON.stringify(res));
                if (res.authSetting['scope.userLocation'] != undefined && res.authSetting['scope.userLocation'] != true) {
                    wx.showModal({
                        title: '请求授权当前位置',
                        content: '需要获取您的地理位置，请确认授权',
                        success: function (res) {
                            if (res.cancel) {
                                wx.showToast({
                                    title: '拒绝授权',
                                    icon: 'none',
                                    duration: 1000
                                })
                            } else if (res.confirm) {
                                wx.openSetting({
                                    success: function (dataAu) {
                                        if (dataAu.authSetting["scope.userLocation"] == true) {
                                            wx.showToast({
                                                title: '授权成功',
                                                icon: 'success',
                                                duration: 1000
                                            })
                                            //再次授权，调用wx.getLocation的API
                                            vm.getLocation();
                                        } else {
                                            wx.showToast({
                                                title: '授权失败',
                                                icon: 'none',
                                                duration: 1000
                                            })
                                        }
                                    }
                                })
                            }
                        }
                    })
                } else if (res.authSetting['scope.userLocation'] == undefined) {
                    //调用wx.getLocation的API
                    vm.getLocation();
                }
                else {
                    //调用wx.getLocation的API
                    vm.getLocation();
                }
            }
        })
    },

    // 微信获得经纬度
    getLocation: function () {
        let vm = this;
        wx.getLocation({
            type: 'wgs84',
            success: function (res) {
                console.log(JSON.stringify(res))
                var latitude = res.latitude
                var longitude = res.longitude
                var speed = res.speed
                var accuracy = res.accuracy;
                vm.getLocal(latitude, longitude)
            },
            fail: function (res) {
                console.log('fail' + JSON.stringify(res))
            }
        })
    },

    // 获取当前地理位置
    getLocal: function (latitude, longitude) {
        let vm = this;
        qqmapsdk.reverseGeocoder({
            location: {
                latitude: latitude,
                longitude: longitude
            },
            success: function (res) {
                //console.log(JSON.stringify(res));
                console.log(res);
                let province = res.result.ad_info.province
                let city = res.result.ad_info.city
                vm.setData({
                    province: province,
                    city: city,
                    district:res.result.ad_info.district,
                    latitude: latitude,
                    longitude: longitude,
                })
            },
            fail: function (res) {
                console.log(res);
            },
            complete: function (res) {
                // console.log(res);
            }
        });
    },

    //获取收获人的名字
    consignee:function(e){
        var consignee = e.detail.value;
        this.setData({
            consignee: consignee,
        })
    },
    //获取电话号码
    telNumber:function(e){
        var telNumber = e.detail.value;
        this.setData({
            telNumber: telNumber
        })
    },
    //获取地址详情
    detailInfo: function (e) {
        var detailInfo = e.detail.value;
        this.setData({
            detailInfo: detailInfo
        })
    },


    //将信息添加至数据库
    Addaddress:function(){
        //添加数据之前，判断 是否有合法的输入
        var consignee = this.data.consignee;
        var telNumber = this.data.telNumber;
        var province = this.data.province;
        var city = this.data.city;
        var district = this.data.district;
        var detailInfo = this.data.detailInfo;
        var username = this.data.userInfo.nickName;

        if (username == null || username == ''){
            wx.showToast({
                title: '请输入您的姓名',
            })
            return false;
        }
        if (telNumber == null || telNumber == '') {
            wx.showToast({
                title: '请输入号码',
            })
            return false;
        } 
        if (detailInfo == null || detailInfo == '') {
            wx.showToast({
                title: '请输入您的详情地址',
            })
            return false;
        } 
        
        //提交至后台保存
        wx.request({
            url: 'http://localhost:8080/WXdemo/addAddress',
            data: {
                consignee: consignee,
                telNumber: telNumber,
                province: province,
                city: city,
                district: district,
                detailInfo: detailInfo,
                username: username,
            },
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded',
            },
            success: function (res) {
                if(res.data==="ok"){
                    console.log("添加成功");
                    //关闭当前页面，返回上一个页面
                    wx.navigateBack({
                        
                    })
                }
            }
        })
    }
})