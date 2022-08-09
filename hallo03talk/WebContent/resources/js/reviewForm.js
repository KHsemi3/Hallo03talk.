const reviewFormBtn = document.querySelector("#reviewFormBtn");
const cancelBtn = reviewForm.querySelector(".btn-danger");

reviewFormBtn.addEventListener("click", () => {
  if (document.querySelector("#reviewForm").classList.contains("showForm")) {
    document.querySelector("#reviewForm").classList.replace("showForm", "hideForm");
  } else {
    document.querySelector("#reviewForm").classList.replace("hideForm", "showForm");
  }
});

cancelBtn.addEventListener("click", () => {
  document.querySelector("#reviewForm").classList.replace("showForm", "hideForm");
});
