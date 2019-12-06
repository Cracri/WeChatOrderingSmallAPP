Page({

    data: {
        "bnrUrl": [{
            "url": "../../image/chuancai1.jpg"
        }, {
            "url": "../../image/sucai1.jpg"
        }, {
            "url": "../../image/yuecai1.jpg"
        }, {
            "url": "../../image/lucai1.jpg"
        }],
        value:'',
        focusInput: false,
        isInput: false,
        isopen: false,
        isgave:0,               //没有点赞
        flag:0
    },

    onLoad: function (options) {
        //获取用户的信息，并且存在该页面数据中
        var userInfo = wx.getStorageSync('userInfo');
        this.setData({
            userInfo: userInfo,
            userPic: userInfo.avatarUrl,
            userName: userInfo.nickName
        })
    },
    // onPageScroll: function (e) {
    //     console.log(e)
    // },

    onShow:function(){
        var that = this;
        //每次刷新数据，显示评论区
        wx.request({
            url: 'http://localhost:8080/WXdemo/getComments',  
            data: {},
            method: 'POST',
            header: {
                'content-type': 'application/json'
            },
            success: function (res) { 
                that.setData({
                    userCommentList:res.data
                })
            }
        })
    },


    focusButn: function () {
        this.setData({
            focusInput: true,
            isInput: true,
            isopen: false
        })
    },

    inputFocus(e) {
        this.setData({
            // height: e.detail.height,
            isInput: true,
            isopen: true
        })
    },

    inputBlur(e) {
        this.setData({
            isInput: false,
            isopen: false,
            value:e.detail.value,
        })
    },


    /*发送消息*/
    sendMessage:function(){
        var that = this;

        var value = this.data.value;
        var userInfo = this.data.userInfo;
        // console.log(value+"---"+userInfo.avatarUrl+"---"+userInfo.nickName)
        wx.request({
            url: 'http://localhost:8080/WXdemo/sendComment',
            data: {
                value:value,
                userPic:userInfo.avatarUrl,
                userName:userInfo.nickName,
            },
            method: 'POST',
            header: {
                'content-type': 'application/x-www-form-urlencoded'
            },
            success:function(res){

                if(res.data === "ok"){
                    wx.showToast({
                        title: '感谢您的评论',
                    })
                    //刷新数据
                    that.onShow();
                }
                //清空原始信息
                that.setData({
                    value:'',
                })
            }
        })
    },


    gaveLike:function(e){
        var that = this;
        let isgave = this.data.isgave;
        let id = e.currentTarget.dataset.id;
        let count = e.currentTarget.dataset.count;
        let index = e.currentTarget.dataset.index;
        

        if (isgave === 0){          //如果没点赞就，允许点击
            wx.request({
                url: 'http://localhost:8080/WXdemo/gaveLikes',
                data: {
                    id:id,
                    count:count
                },
                method: 'POST',
                header: {
                    'content-type': 'application/x-www-form-urlencoded'
                },
                success: function (res) {
                    if(res.data === "ok"){
                        that.flushComment(index);
                        
                        that.setData({
                            flag:1,
                            isgave:1
                        })
                    }
                }
            })
        }else{
            //取消点赞
            wx.request({
                url: 'http://localhost:8080/WXdemo/cancleLikes',
                data: {
                    id: id,
                    count: count
                },
                method: 'POST',
                header: {
                    'content-type': 'application/x-www-form-urlencoded'
                },
                success: function (res) {
                    if (res.data === "ok") {
                        that.flushComment(index);
                        
                        that.setData({
                            flag: 0,
                            isgave:0
                        })
                    }
                }
            })
        }
        
    },


    flushComment: function (index){
        var that = this;
        console.log("index:"+index)
        //每次刷新数据，显示评论区
        wx.request({
            url: 'http://localhost:8080/WXdemo/getComments',
            data: {},
            method: 'POST',
            header: {
                'content-type': 'application/json'
            },
            success: function (res) {
                that.setData({
                    userCommentList: res.data
                })

                let flag = that.data.flag;
                if (flag == 1) {
                    let userCommentList = that.data.userCommentList;
                    //改变图标的颜色
                    let isgave = "userCommentList[" + index + "].isGave";
                    that.setData({
                        [isgave]: 1
                    })
                } else {
                    let userCommentList = that.data.userCommentList;
                    //改变图标的颜色
                    let isgave = "userCommentList[" + index + "].isGave";
                    that.setData({
                        [isgave]: 0
                    })
                }
            }
        })
    }


})