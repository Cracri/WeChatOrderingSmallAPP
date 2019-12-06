const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}


//得到一个表单
 function getOrderNumber(){
    wx.request({
        url: 'http://localhost:8080/WXdemo/getOrderCode',  //本地服务器地址
        data: {},
        method: 'POST',
        header: {
            'content-type': 'application/json' //默认值
        },
        success: function (res) {
            console.log("订单编号:" + res.data);
            var code = wx.getStorageSync('code');
            if (code == null) {
              wx.setStorageSync("code", res.data);
            }
        },
    })
   
}

function getString(){
    return 'ss';
}

module.exports = {
  formatTime: formatTime,
  getOrderNumber: getOrderNumber,
  getString: getString,
}
