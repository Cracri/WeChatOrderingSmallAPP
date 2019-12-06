var app = getApp();
var that = this;
Page({
    data: {
        productList: null,
        emptySomething: true,                   //表示当前没有商品
        length:0,
        totalMoney: 0,                          //总价
        productId_hidden:0,
        delProduct:[],                          //删除数据的 数组
        price:0,
        showModalStatus:false,
        addrssHiden:false,
        address:'无'
    },

    onLoad:function(){
    },

    onShow: function () {
        //得到订单编号  
        var code = wx.getStorageSync("code");
        this.setData({
            code: code
        })

        var that = this;
        var length = this.data.length;
        var emptySomething = this.data.emptySomething;
        var totalMoney = this.data.totalMoney;

        //取得购买的菜品
        wx.request({
            url: 'http://localhost:8080/WXdemo/getOrderDetail',  //本地服务器地址
            data: {
                orderNumber: this.data.code,                     //订单编号
            },
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded', 
            },
            success: function (res) {
                if(res.data == null){
                    //清除该页面上次操作所保留的数据
                    that.setData({
                        productList:null,
                        totalMoney:0,
                        length:0,
                        productCount:0,                     //点餐的 数量。
                        productTotalPrice:0,   
                        emptySomething:true,
                        remark:0
                    })
                }else{
                    var orderDetailList = res.data;
                    var newLength = 0;
                    var newTotalMoney  = 0;
                    //更新数量
                    for(var i=0;i<orderDetailList.length;i++){
                        newLength +=  orderDetailList[i].productCount;
                    }
                    //更新总价
                    for (var i = 0; i < orderDetailList.length ; i++){
                        newTotalMoney += orderDetailList[i].productPrice * orderDetailList[i].productCount;
                    }

                    that.setData({
                        length: newLength,
                        emptySomething: false,
                        productList: orderDetailList,
                        totalMoney: newTotalMoney
                    })
                }
            },
        })
        
    },

    getRemark:function(e){
        this.setData({
            remark:e.detail.value
        })
    },

   


    //添加商品数量
    addProductCount:function(e){
        var index = e.target.dataset.index;                          //获得当前对象的下标
        var newProductCount = this.data.productList[index].productCount;  //获取当前对象的商品数量
        var productPrice = this.data.productList[index].productPrice;//获取当前对象的商品价格
        var newLength = this.data.length;

        newLength ++;
        newProductCount++;              //增加数量
        var newTotalPrice = this.data.totalMoney * 1 + productPrice * 1;
        var newProductList = "productList[" + index +"].productCount";
        this.setData({
            [newProductList]: newProductCount,
            totalMoney: newTotalPrice,
            length: newLength
        })

        //向后台发出增加数量的请求
        wx.request({
            url: 'http://localhost:8080/WXdemo/addProductCount',
            data:{
                orderNumber:this.data.code,
                productId: this.data.productList[index].productId,
                productName: this.data.productList[index].productName,
                productPrice: this.data.productList[index].productPrice,
            },
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded', 
            },
            success:function(res){}
        })
    },

    //减少商品的数量
    subProductCount:function(e){
        var index = e.target.dataset.index;                                //获得当前对象的下标
        //判断能否减少餐品
        var productCount = this.data.productList[index].productCount;
        if (productCount <= 1){
            wx.showToast({
                title: '当前您不能减少了',
            })
            return false;
        }
        
        var newProductCount = this.data.productList[index].productCount;   //获取当前对象的商品数量
        var productPrice = this.data.productList[index].productPrice;   //获取当前对象的商品价格
        var newLength = this.data.length;
        newLength--;

        newProductCount--;              //减少数量
        var newTotalPrice = this.data.totalMoney * 1 - productPrice * 1;
        var newProductList = "productList[" + index + "].productCount";
        this.setData({
            [newProductList]: newProductCount,
            totalMoney: newTotalPrice,
            length: newLength,
        })
        //向后台请求 减少商品数量 
        wx.request({
            url: 'http://localhost:8080/WXdemo/subProductCount',
            data: {
                orderNumber: this.data.code,
                productId: this.data.productList[index].productId,
                productPrice: this.data.productList[index].productPrice,
            },
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded', //默认值（post提交的格式）
            },
            success: function (res) {
            }
        })

    },


    //删除该订餐
    delProduct:function(e){
        var that = this;
        var length = this.data.length;
        var index = e.target.dataset.index;
        var orderNumber= this.data.code,
            productId= this.data.productList[index].productId,
            productPrice= this.data.productList[index].productPrice;
        var delProduct = this.data.delProduct;
        
        wx.showModal({
            title: '提示',
            content: '确定要删除吗？',
            success:function(res){
                //如果用户点击了确定,删除该商品，并且刷新 storagesync 中的数据
                if(res.confirm){
                    /*1.将要删除的数据保存在，数组中。
                     * 2.再将数组保存再域中 */
                    //将删除的数据 保存在数组中
                    app.globalData.delProduct.push(that.data.productList[index]);
                    //将数组保存在  storagesync 域中
                    wx.setStorageSync("delProductList", app.globalData.delProduct);

                    //向后台请求删除数据
                    wx.request({
                        url: 'http://localhost:8080/WXdemo/delProductCount',
                        data: {
                            orderNumber: orderNumber,
                            productId: productId,
                            productPrice: productPrice
                        },
                        method: 'post',
                        header: {
                            'content-type': 'application/x-www-form-urlencoded', 
                        },
                        success:function(res){
                            //刷新数据
                            that.onShow();

                            var length = that.data.length;
                            var totalMoney = that.data.totalMoney;

                            //判断是否还有商品
                            // var length = that.data.length;
                            // console.log("lenght:"+length);
                            // if (length == 0){
                            //     that.setData({
                            //         emptySomething:true
                            //     })
                            // }
                        },
                    })
                }
            }
        })
    },


    /*获取吃饭方式的值 */
    getRadioValue:function(e){
        var that = this;
        if (e.detail.value === '1'){
            that.setData({
                addrssHiden:true,//隐藏选择地址框
            })
        }else{
            that.setData({
                addrssHiden:false,//显示地址框
            })
        }
    },
    //如果用户选择了外卖点餐，就获取地址
    getAddress:function(){
        var str = '';
        str += this.data.consignee +"  "+ this.data.telNumber +"  " +this.data.provinceName + this.data.cityName + this.data.districtName + this.data.detailInfo;
        this.setData({
            address: str,
        })
    },

    //选择收获地址
    nativeToAddress:function(){
        //不关闭当前页面，跳转到地址页面.(使用wx.navigateBack 可返回,得到传回来的值，保存进来。)
        wx.navigateTo({
            url: '/pages/address/address',
        })
        
    },

    /***结算功能 */
    powerDrawer: function (e) {
        //先判断是否可以结算
        var length = this.data.length;
        if (length<=0){
            wx.showToast({
                title: '您还没有点餐哟',
            })
            return false;
        }

        var currentStatu = e.currentTarget.dataset.statu;
        this.util(currentStatu)
    },
    util: function (currentStatu) {
        var that = this;
        /* 动画部分 */
        // 第1步：创建动画实例   
        var animation = wx.createAnimation({
            duration: 200,  //动画时长  
            timingFunction: "linear", //线性  
            delay: 0  //0则不延迟  
        });

        // 第2步：这个动画实例赋给当前的动画实例  
        this.animation = animation;

        // 第3步：执行第一组动画  
        animation.opacity(0).rotateX(-100).step();

        // 第4步：导出动画对象赋给数据对象储存  
        this.setData({
            animationData: animation.export()
        })

        // 第5步：设置定时器到指定时候后，执行第二组动画  
        setTimeout(function () {
            // 执行第二组动画  
            animation.opacity(1).rotateX(0).step();
            // 给数据对象储存的第一组动画，更替为执行完第二组动画的动画对象  
            this.setData({
                animationData: animation
            })
            //关闭  
            if (currentStatu == "close") {
                this.setData(
                    {
                        showModalStatus: false,
                        addrssHiden:false,
                    }
                );
            }
        }.bind(this), 200)

        // 显示  
        if (currentStatu == "open"){
            this.setData(
                {
                    showModalStatus: true
                }
            );
        }

        if (currentStatu == "pay"){
            that.getAddress();
            var code = that.data.code;
            var showModalStatus = that.data.showModalStatus;
            var remark = that.data.remark;
            var address = that.data.address;
            
            var addrssHiden = that.data.addrssHiden;
            if (addrssHiden == false){         //
                address = '无';
            }

            //付款，修改数据
            wx.request({
                url: 'http://localhost:8080/WXdemo/payOrder',
                data: {
                    orderNumber: code,
                    remark: remark,
                    address: address,
                },
                method: 'post',
                header: {
                    'content-type': 'application/x-www-form-urlencoded',
                },
                success: function (res) {
                    if(res.data === res.data){
                        that.setData({
                            showModalStatus: false,
                            remark:0,
                        })
                        //付款成功后，重新生成一个新的订单
                        app.getOrderNumber();
                        //关闭所有页面，跳转到主页面
                        wx.reLaunch({
                            url: '../market/market',
                        })

                    }else{
                        // console.log("error")
                        return false;
                    }
                    
                },
            })
        }
    },




    
})
