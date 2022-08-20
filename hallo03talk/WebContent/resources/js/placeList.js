// index로 문자열 변경하기
// String.prototype.replaceAt = function (index, word) {
//   if (index >= this.length) {
//     return this.valueOf();
//   }
//   return this.substring(0,index) + word + this.substring(index+1);
// }

function clickCategory(x) {
  const nowURL = location.href;
  const changeURL = nowURL.substring(0,nowURL.indexOf('&cityNo=')-1) + x + nowURL.substring(nowURL.indexOf('&cityNo='));
  // const changeURL =  nowURL.replaceAt(nowURL.indexOf('&cityNo=')-1,x);
  location.href = changeURL;
}

function clickCity(x) {
  const nowURL = location.href;
  const changeURL = nowURL.substring(0,nowURL.indexOf('&insideNo=')-1) + x + nowURL.substring(nowURL.indexOf('&insideNo='));
  // const changeURL =  nowURL.replaceAt(nowURL.indexOf('&insideNo=')-1,x);
  location.href = changeURL;
}

function clickInside(x) {
  const nowURL = location.href;
  const changeURL = nowURL.substring(0,nowURL.indexOf('insideNo=0')+9) + x + nowURL.substring(nowURL.indexOf('insideNo=0')+10);
  // const changeURL =  nowURL.replaceAt(nowURL.indexOf('insideNo=0')+9,x);
  location.href = changeURL;
}