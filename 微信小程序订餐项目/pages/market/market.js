var app = getApp();
var that = this;
Page({
  data: {
    currentTab:0,
    flag:0,
    name:'', 
    productId_hidden:false,             //对productId  的隐藏
    productCount:0,                     //点餐的 数量。
    productTotalPrice:0,                //点餐的 总价
    showOrder:false,                      //详情订单页面的显示
    delArray:[],                         //删除的商品的Id
    delProduct:[],
    purchasedProduct:0
  },
    
    onLoad:function(){
        var that = this;
        //得到storage中的用户信息,并保存在当前页面中
        var userinfo = wx.getStorageSync("userInfo");
        this.setData({
            userInfo: userinfo
        })

        // wx.request({
        //     url: 'http://129.28.70.46:8080/WXdemo/TestDemo',
        //     header:{
        //         "content-type":"application/json",
        //     },      
        //     method:'POST',
        //     success:function(res){
        //         console.log("ss:"+res.data);
        //     }
        // })

        wx.request({
            url: 'http://localhost:8080/WXdemo/findChuanCai',
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded' //默认值
            },
            dataType:'json',
            success: function (res) {
                that.setData({
                    menusChuanCaiList: res.data,
                });

                //查找粤菜的菜单
                wx.request({
                    url: 'http://localhost:8080/WXdemo/findYueCai',  //本地服务器地址
                    data: {},
                    method: 'get',
                    header: {
                        'content-type': 'application/json' //默认值
                    },
                    success: function (res) {
                        that.setData({
                            menusYueCaiList: res.data,
                        });

                        //查找苏菜的菜单
                        wx.request({
                            url: 'http://localhost:8080/WXdemo/findSuCai',  
                            data: {},
                            method: 'get',
                            header: {
                                'content-type': 'application/json' //默认值
                            },
                            success: function (res) {
                                that.setData({
                                    menusSuCaiList: res.data,
                                });

                                //查找鲁菜的菜单
                                wx.request({
                                    url: 'http://localhost:8080/WXdemo/findLuCai',  //本地服务器地址
                                    data: {},
                                    method: 'get',
                                    header: {
                                        'content-type': 'application/json' //默认值
                                    },
                                    success: function (res) {
                                        that.setData({
                                            menusLuCaiList: res.data,
                                        });
                                    }
                                })
                            }
                        })
                    }
                })
            }
        })

        
    },

    onShow:function(){
        //刷新该页面得到一个 订单
        var code = wx.getStorageSync("code");
        this.setData({
            code: code
        })

        var that = this;
        //取得购物车删除商品域中的值
        var delProductList = wx.getStorageSync("delProductList");
        // console.log(delProductList)

        var delArray = this.data.delArray;
        //**清空上一次 删除操作的 留下的数据**//
        delArray = [];

        if(delProductList.length <= 0){}
        else{
            /**修改购买 标志 */
            //得到所有删除的ProductId  传入后台 返回一个 菜品的集合
            for (var i = 0; i < delProductList.length; i++) {
                //如果数组中 存在了 那个元素，就不需要
                if (delArray[i] == delProductList[i].productId) {
                    continue;
                } else {
                    delArray.push(delProductList[i].productId);
                    }
            }
            //向后台请求，返回被删除的商品的Id
            wx.request({
                url: 'http://localhost:8080/WXdemo/findDelProduct',  //本地服务器地址
                data: {
                    delArray: delArray,
                },
                method: 'post',
                header: {
                    'content-type': 'application/x-www-form-urlencoded',
                },
                success: function (res) {
                    //得到被删除product的数据
                    var list = res.data;
                    // console.log(list)
                    
                    //判断数据的长度
                    for(var i=0;i<list.length;i++){
                        //判断 该条数据 的类型
                        if(list[i].type == 1){
                            //修改是否 购买
                            var newIsbuy = "menusChuanCaiList[" + (list[i].id - 1) + "].isBuy";
                            that.setData({
                                [newIsbuy]:0
                            })
                        } else if (list[i].type == 2){
                            //修改是否 购买
                            var newIsbuy = "menusYueCaiList[" + (list[i].id - 1) + "].isBuy";
                            that.setData({
                                [newIsbuy]: 0
                            })
                        } else if (list[i].type == 3){
                            //修改是否 购买
                            var newIsbuy = "menusSuCaiList[" + (list[i].id - 1) + "].isBuy";
                            that.setData({
                                [newIsbuy]: 0
                            })
                        }else if(list[i].type == 4){
                            //修改是否 购买
                            var newIsbuy = "menusLuCaiList[" + (list[i].id - 1) + "].isBuy";
                            that.setData({
                                [newIsbuy]: 0
                            })
                        }
                    }
                    //修改成功后，使其删除域  中 清空
                    wx.removeStorage({
                        key:'delProductList',
                        success:function(res){
                        }
                    })
                    //清空被删除的Product的数据*****
                    app.globalData.delProduct = [];
                }
            })
        }

        //取得已购买的菜品（更新超市的 数量和 总价）
        wx.request({
            url: 'http://localhost:8080/WXdemo/getOrderDetail',  //本地服务器地址
            data: {
                orderNumber: this.data.code,                     //订单编号
            },
            method: 'post',
            header: {
                'content-type': 'application/x-www-form-urlencoded', //默认值（post提交的格式）
            },
            success: function (res) {
                if(res.data == null){
                    //如果当前订单为空的话，就刷新数据
                    that.onLoad();
                    //同时 刷新 总价 和 数量的数据
                    that.setData({
                        productCount: 0,                    
                        productTotalPrice: 0,   
                    })
                }else{
                    var orderdetailList = res.data;

                    var newLength = 0;
                    var newTotalMoney = 0;
                    //更新数量
                    for (var i = 0; i < orderdetailList.length; i++) {
                        newLength += orderdetailList[i].productCount;
                    }
                    //更新总价
                    for (var i = 0; i < orderdetailList.length; i++) {
                        newTotalMoney += orderdetailList[i].productPrice * orderdetailList[i].productCount;
                    }

                    that.setData({
                        productTotalPrice: newTotalMoney,
                        productCount: newLength,
                        alaCarte:res.data,
                        purchasedProduct:res.data,  //保存已购买的商品，防止取消bug出现
                    })

                }
            },
        })

},

switchNav:function(e){
    var page = this;
    var id=e.target.id;

    if(this.data.currentTab==id){
        return false;
    }else{
        page.setData({
            currentTab:id
        });
    }
    page.setData({
      flag:id
    });
},


  //增加甜点的数量
  addDessertCount:function(e){
    var index = (e.target.dataset.index);       //获得当前的对象
    var newCount = this.data.menusDessertList[index].buyCount;
    var surplus = this.data.menusDessertList[index].surplus;

    surplus --;             //库存减少
    newCount ++;            //购买量增加
    
    if(surplus < 0){
      wx.showToast({
        title: '库存不足',
      })
      return false;
    }
    var newList_buyCount = "menusDessertList["+index+"].buyCount";
    var newList_surplus = "menusDessertList[" + index + "].surplus";
    this.setData({
      [newList_buyCount]:newCount,
      [newList_surplus]:surplus,
    })
  },
  //减少甜点的数量
  decreaseDessertCount:function(e){
    var index = (e.target.dataset.index);       //获得当前的对象
    var newCount = this.data.menusDessertList[index].buyCount;
    var surplus = this.data.menusDessertList[index].surplus;

    surplus++;             //库存增加
    newCount--;            //购买量减少

    if (newCount < 0) {
      wx.showToast({
        title: '当前不能减少了',
      })
      return false;
    }
    var newList_buyCount = "menusDessertList[" + index + "].buyCount";
    var newList_surplus = "menusDessertList[" + index + "].surplus";
    this.setData({
      [newList_buyCount]: newCount,
      [newList_surplus]: surplus,
    })
  },




  //是否购买  ************************
  isbuyTap:function(e){
    var index = e.target.dataset.index;                 //当前菜的 第几种菜
    var isbuy = e.target.dataset.isbuy;                 //是否购买
    var type = e.target.dataset.type;                   //菜的类型
  
    if(type == 1){                    //对川菜的添加
      if (isbuy == 0) {
        var currentProduct = this.data.menusChuanCaiList[index];
        var currentPrice = currentProduct.productPrice;
        var newTotalPrice = this.data.productTotalPrice * 1 + currentPrice * 1; 
        this.setData({
            productTotalPrice: newTotalPrice,
        })
        //将购买的菜品加入到订单  和 详情订单中
        wx.request({
            url: 'http://localhost:8080/WXdemo/addOrder',  //本地服务器地址
            data: {
                proName:currentProduct.productName,             //商品名字
                proId: currentProduct.productId,                //商品id
                proPrc: currentProduct.productPrice,            //商品价格
                proPic: currentProduct.productPic,              //商品图片
                orderConsignee:this.data.userInfo.nickName,     //客户名称
                orderNumber:this.data.code,                     //订单编号
                orderDeskNumber:1                               //桌号
            },
            method: 'POST',
            header: {
                'content-type': 'application/x-www-form-urlencoded',
            },
            success: function (res) {}
        })
        //购物车的 图标 + 1
        var newProductCount = this.data.productCount;
            newProductCount++; 
        this.setData({
            productCount: newProductCount,
        })
        isbuy = 1;                    //表示当前产品已经被购买 --> 显示  取消
      } else {
        var currentProduct = this.data.menusChuanCaiList[index];
          //当点击取消的时候，判断该商品被客户点了是否2次，如果大于2次就不能取消
          var judgeCancel = this.judgeCancel(currentProduct);
          if (judgeCancel == false) {
              return false;
          }
        var currentPrice = currentProduct.productPrice;
        var newTotalPrice = this.data.productTotalPrice * 1 - currentPrice * 1; 
        this.setData({
          productTotalPrice: newTotalPrice,
        })

        //将点的餐 删除
        wx.request({
            url: 'http://localhost:8080/WXdemo/delOrder',  //本地服务器地址
            data: {
                proName: currentProduct.productName,             //商品名字
                proId: currentProduct.productId,                //商品id
                proPrc: currentProduct.productPrice,            //商品价格
                proPic: currentProduct.productPic,              //商品图片
                orderConsignee: this.data.userInfo.nickName,     //客户名称
                orderNumber: this.data.code,                     //订单编号
                orderDeskNumber: 1                               //桌号
            },
            method: 'POST',
            header: {
                'content-type': 'application/x-www-form-urlencoded',
            },
            success: function (res) {}
        })
        //
        var newProductCount = this.data.productCount;
        newProductCount--;
        this.setData({
            productCount: newProductCount,
        })
        isbuy = 0;                    //表示当前产品未被购买  -->  显示 添加
      }
      var newIsbuy = "menusChuanCaiList[" + index + "].isBuy";
      this.setData({                    //更新购买信息
        [newIsbuy]: isbuy,
      })                //************************************** */
    }else if(type == 2){              //对粤菜的添加
      if (isbuy == 0) {
          var currentProduct = this.data.menusYueCaiList[index];
          var currentPrice = currentProduct.productPrice;
          var newTotalPrice = this.data.productTotalPrice * 1 + currentPrice * 1; //*1 转换为整型
          this.setData({
              productTotalPrice: newTotalPrice,
          })
          //将购买的菜品加入到订单  和 详情订单中
          wx.request({
              url: 'http://localhost:8080/WXdemo/addOrder',  //本地服务器地址
              data: {
                  proName: currentProduct.productName,             //商品名字
                  proId: currentProduct.productId,                //商品id
                  proPrc: currentProduct.productPrice,            //商品价格
                  proPic: currentProduct.productPic,              //商品图片
                  orderConsignee: this.data.userInfo.nickName,     //客户名称
                  orderNumber: this.data.code,                     //订单编号
                  orderDeskNumber: 1                               //桌号
              },
              method: 'POST',
              header: {
                  'content-type': 'application/x-www-form-urlencoded',
              },
              success: function (res) { }
          })
          //购物车的 图标 + 1
          var newProductCount = this.data.productCount;
          newProductCount++;
          this.setData({
              productCount: newProductCount,
          })
          isbuy = 1;                    //表示当前产品已经被购买 --> 显示  取消
      } else {
          var currentProduct = this.data.menusYueCaiList[index];
          //当点击取消的时候，判断该商品被客户点了是否2次，如果大于2次就不能取消
          var judgeCancel = this.judgeCancel(currentProduct);
          if (judgeCancel == false) {
              return false;
          }
          var currentPrice = currentProduct.productPrice;
          var newTotalPrice = this.data.productTotalPrice * 1 - currentPrice * 1;
          this.setData({
              productTotalPrice: newTotalPrice,
          })

          //将点的餐 删除
          wx.request({
              url: 'http://localhost:8080/WXdemo/delOrder',  //本地服务器地址
              data: {
                  proName: currentProduct.productName,             //商品名字
                  proId: currentProduct.productId,                //商品id
                  proPrc: currentProduct.productPrice,            //商品价格
                  proPic: currentProduct.productPic,              //商品图片
                  orderConsignee: this.data.userInfo.nickName,     //客户名称
                  orderNumber: this.data.code,                     //订单编号
                  orderDeskNumber: 1                               //桌号
              },
              method: 'POST',
              header: {
                  'content-type': 'application/x-www-form-urlencoded',
              },
              success: function (res) { }
          })
          //
          var newProductCount = this.data.productCount;
          newProductCount--;
          this.setData({
              productCount: newProductCount,
          })
          isbuy = 0;                    //表示当前产品未被购买  -->  显示 添加
      }
      var newIsbuy = "menusYueCaiList[" + index + "].isBuy";
      this.setData({
        [newIsbuy]: isbuy,
      })              /********************************************8 */
    }else if(type == 3){
        if (isbuy == 0) {
            var currentProduct = this.data.menusSuCaiList[index];
            var currentPrice = currentProduct.productPrice;
            var newTotalPrice = this.data.productTotalPrice * 1 + currentPrice * 1; //*1 转换为整型
            this.setData({
                productTotalPrice: newTotalPrice,
            })
            //将购买的菜品加入到订单  和 详情订单中
            wx.request({
                url: 'http://localhost:8080/WXdemo/addOrder',  //本地服务器地址
                data: {
                    proName: currentProduct.productName,             //商品名字
                    proId: currentProduct.productId,                //商品id
                    proPrc: currentProduct.productPrice,            //商品价格
                    proPic: currentProduct.productPic,              //商品图片
                    orderConsignee: this.data.userInfo.nickName,     //客户名称
                    orderNumber: this.data.code,                     //订单编号
                    orderDeskNumber: 1                               //桌号
                },
                method: 'POST',
                header: {
                    'content-type': 'application/x-www-form-urlencoded',
                },
                success: function (res) { }
            })
            //购物车的 图标 + 1
            var newProductCount = this.data.productCount;
            newProductCount++;
            this.setData({
                productCount: newProductCount,
            })
            isbuy = 1;                    //表示当前产品已经被购买 --> 显示  取消
        } else {
            var currentProduct = this.data.menusSuCaiList[index];
            //当点击取消的时候，判断该商品被客户点了是否2次，如果大于2次就不能取消
            var judgeCancel = this.judgeCancel(currentProduct);
            if (judgeCancel == false) {
                return false;
            }
            var currentPrice = currentProduct.productPrice;
            var newTotalPrice = this.data.productTotalPrice * 1 - currentPrice * 1; 
            this.setData({
                productTotalPrice: newTotalPrice,
            })

            //将点的餐 删除
            wx.request({
                url: 'http://localhost:8080/WXdemo/delOrder',  //本地服务器地址
                data: {
                    proName: currentProduct.productName,             //商品名字
                    proId: currentProduct.productId,                //商品id
                    proPrc: currentProduct.productPrice,            //商品价格
                    proPic: currentProduct.productPic,              //商品图片
                    orderConsignee: this.data.userInfo.nickName,     //客户名称
                    orderNumber: this.data.code,                     //订单编号
                    orderDeskNumber: 1                               //桌号
                },
                method: 'POST',
                header: {
                    'content-type': 'application/x-www-form-urlencoded',
                },
                success: function (res) { }
            })
            //
            var newProductCount = this.data.productCount;
            newProductCount--;
            this.setData({
                productCount: newProductCount,
            })
            isbuy = 0;                    //表示当前产品未被购买  -->  显示 添加
        }
        var newIsbuy = "menusSuCaiList[" + index + "].isBuy";
        this.setData({
            [newIsbuy]: isbuy,
        })              /********************************************8 */
    }else if (type == 4) {
        if (isbuy == 0) {
            var currentProduct = this.data.menusLuCaiList[index];
            var currentPrice = currentProduct.productPrice;
            var newTotalPrice = this.data.productTotalPrice * 1 + currentPrice * 1; 
            this.setData({
                productTotalPrice: newTotalPrice,
            })
            //将购买的菜品加入到订单  和 详情订单中
            wx.request({
                url: 'http://localhost:8080/WXdemo/addOrder',  //本地服务器地址
                data: {
                    proName: currentProduct.productName,             //商品名字
                    proId: currentProduct.productId,                //商品id
                    proPrc: currentProduct.productPrice,            //商品价格
                    proPic: currentProduct.productPic,              //商品图片
                    orderConsignee: this.data.userInfo.nickName,     //客户名称
                    orderNumber: this.data.code,                     //订单编号
                    orderDeskNumber: 1                               //桌号
                },
                method: 'POST',
                header: {
                    'content-type': 'application/x-www-form-urlencoded',
                },
                success: function (res) { }
            })
            //购物车的 图标 + 1
            var newProductCount = this.data.productCount;
            newProductCount++;
            this.setData({
                productCount: newProductCount,
            })
            isbuy = 1;                    //表示当前产品已经被购买 --> 显示  取消
        } else {
            var currentProduct = this.data.menusLuCaiList[index];

            //当点击取消的时候，判断该商品被客户点了是否2次，如果大于2次就不能取消
            var judgeCancel = this.judgeCancel(currentProduct);
            if (judgeCancel == false) {
                return false;
            }
            var currentPrice = currentProduct.productPrice;
            var newTotalPrice = this.data.productTotalPrice * 1 - currentPrice * 1;
            this.setData({
                productTotalPrice: newTotalPrice,
            })

            //将点的餐 删除
            wx.request({
                url: 'http://localhost:8080/WXdemo/delOrder',  //本地服务器地址
                data: {
                    proName: currentProduct.productName,             //商品名字
                    proId: currentProduct.productId,                //商品id
                    proPrc: currentProduct.productPrice,            //商品价格
                    proPic: currentProduct.productPic,              //商品图片
                    orderConsignee: this.data.userInfo.nickName,     //客户名称
                    orderNumber: this.data.code,                     //订单编号
                    orderDeskNumber: 1                               //桌号
                },
                method: 'POST',
                header: {
                    'content-type': 'application/x-www-form-urlencoded',
                },
                success: function (res) { }
            })
            //更新购买的数量
            var newProductCount = this.data.productCount;
            newProductCount--;
            this.setData({
                productCount: newProductCount,
            })
            isbuy = 0;                    //表示当前产品未被购买  -->  显示 添加
        }
        var newIsbuy = "menusLuCaiList[" + index + "].isBuy";
        this.setData({
            [newIsbuy]: isbuy,
        })              /********************************************8 */
    }
  },



//显示点的套餐
openOrder:function(){
    var that = this;
    var productCount = this.data.productCount;
    if (productCount <= 0) {
        wx.showToast({
            title: '您还没有点餐哟'
        })
        return false;
    }
    this.setData({
        showOrder:true,
    })

    //同时从数据库中 返回 点的餐
    wx.request({
        url: 'http://localhost:8080/WXdemo/getOrderDetail',  //本地服务器地址
        data: {
            orderNumber: this.data.code,                     //订单编号
        },
        method: 'post',
        header: {
            'content-type': 'application/x-www-form-urlencoded', //默认值（post提交的格式）
        },
        success: function (res) {
            that.setData({
                alaCarte:res.data,              //已经点的菜品
            })
        }
    })
},
//关闭点的套餐
closeOrder: function () {
    this.setData({
        showOrder: false,
    })
},

//查询点餐的数据
getOrderDetail:function(){
    wx.request({
        url: 'http://localhost:8080/WXdemo/getOrderDetail',  //本地服务器地址
        data: {
            orderNumber: this.data.code,                     //订单编号
        },
        method: 'post',
        header: {
            'content-type': 'application/x-www-form-urlencoded', //默认值（post提交的格式）
        },
        success: function (res) {
            //判断返回得到的数据是否为空
            if(res.data == "null"){
                return false;
            }else{
                var orderDetailList = res.data;
                //将数据缓存
                wx.setStorageSync('orderDetailList', orderDetailList);
            } 
        },
    })
},



//再取消之前需要判断，该商品的Count是否>=2
judgeCancel:function(e){
    var purchased = this.data.purchasedProduct;
    //遍历
    for (var i = 0; i < purchased.length;i++){
        //通过productName
        if (e.productName === purchased[i].productName){
            if (purchased[i].productCount>1){
                wx.showToast({ 
                    title: '请在购物车中删除',
                })
                return false;
            }
        }
    }
},


})