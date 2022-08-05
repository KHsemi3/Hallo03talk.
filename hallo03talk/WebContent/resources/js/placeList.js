// 선택시 색 변경, 읍면동 변경
const jeju = document.querySelector("#jeju");
const seogwipo = document.querySelector("#seogwipo");
const injeju = document.querySelectorAll(".in-jeju");
const inseogwipo = document.querySelectorAll(".in-seogwipo");

jeju.addEventListener("click", (e) => {
  jeju.classList.add("bg-warning");
  seogwipo.classList.remove("bg-warning");
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
  injeju.forEach((item) => {
    item.classList.add("d-none");
  });
  inseogwipo.forEach((item) => {
    item.classList.remove("d-none");
  });
});
