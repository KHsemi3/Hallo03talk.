const placeCategory = document.querySelector('#placeCategory');
// 선택시 색 변경, 읍면동 변경
const jeju = placeCategory.querySelector("#jeju");
const seogwipo = placeCategory.querySelector("#seogwipo");
const injeju = placeCategory.querySelectorAll(".in-jeju");
const inseogwipo = placeCategory.querySelectorAll(".in-seogwipo");
const allview = placeCategory.querySelector('#allview');
jeju.addEventListener("click", (e) => {
  jeju.classList.add("bg-warning");
  seogwipo.classList.remove("bg-warning");
  allview.classList.remove("bg-warning");
  inseogwipo.forEach((item) => {
    item.classList.add("d-none");
  });
  injeju.forEach((item) => {
    item.classList.remove("d-none");
  });
});

seogwipo.addEventListener("click", (e) => {
  seogwipo.classList.add("bg-warning");
  jeju.classList.remove("bg-warning");
  allview.classList.remove("bg-warning");
  injeju.forEach((item) => {
    item.classList.add("d-none");
  });
  inseogwipo.forEach((item) => {
    item.classList.remove("d-none");
  });
});

allview.addEventListener('click',() => {
  allview.classList.add('bg-warning');
  jeju.classList.add("bg-warning");
  seogwipo.classList.add("bg-warning");
  jeju.classList.remove("bg-warning");
  seogwipo.classList.remove("bg-warning");
  injeju.forEach((item) => {
    item.classList.add("d-none");
  });
  inseogwipo.forEach((item) => {
    item.classList.add("d-none");
  });
})

