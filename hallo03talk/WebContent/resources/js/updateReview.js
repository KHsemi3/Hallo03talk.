const delBtn = document.querySelector("#delReview");
const commentCancel = commentForm.querySelector(".btn-danger");

delBtn.addEventListener("click", () => {
  if (confirm("삭제 하시겠읍니까?")) {
    alert("확인");
  } else {
    alert("취소");
  }
});

const writeBtn = document.querySelector("#writeReview");
writeBtn.addEventListener("click", () => {
  if (document.querySelector("#commentForm").classList.contains("showForm")) {
    document.querySelector("#commentForm").classList.replace("showForm", "hideForm");
  } else {
    document.querySelector("#commentForm").classList.replace("hideForm", "showForm");
  }
});

commentCancel.addEventListener("click", () => {
  document.querySelector("#commentForm").classList.replace("showForm", "hideForm");
});
