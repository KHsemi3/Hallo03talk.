const delBtn = document.querySelector("#delReview");

delBtn.addEventListener("click", () => {
  if (confirm("삭제 하시겠읍니까?")) {
    alert("확인");
  } else {
    alert("취소");
  }
});
