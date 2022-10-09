document.addEventListener("DOMContentLoaded", () => {

  // Modal
  const modals = document.querySelectorAll(".modal")

  if(modals) {
    const closeButton = document.querySelectorAll(".modal .close")
    const closeModal = () => {
      modals.forEach(modal => {
        modal.classList.remove("active")
      })
    }

    closeButton.forEach(button => {
      button.addEventListener("click", closeModal)
    })
  }

  // 디자인스킨: 스킨 선택
  // const contentSkins = document.querySelector("main.skins")

  // if (contentSkins) {
  //   const pageTitle = document.querySelector(".page_tit")
  //   const skinsMenu = document.querySelector(".select_type")

  //   pageTitle.addEventListener("click", () => {
  //     skinsMenu.style.width = `${pageTitle.offsetWidth}px`
  //     skinsMenu.classList.toggle("is_active")
  //   })
  // }

  // 가격안내: FAQ
  const questions = document.querySelectorAll(".question");

  if(questions) {
    const showLists = (event) => {
      let questionIndex = [...questions].indexOf(event.target);
      questions.forEach(question => {
        const list = question.closest(".faq");
        [...questions].indexOf(question) === questionIndex
          ? list.classList.toggle("is_active")
          : list.classList.remove("is_active");
      });
    }
    questions.forEach(question => {
      question.addEventListener("click", showLists);
    })
  };

  setTimeout(() => {
    const tooltips = document.querySelectorAll(".tooltip");
    tooltips.forEach(tooltip => {
      tooltip.addEventListener("click", (event) => {
        const { target } = event;

        event.preventDefault();
        event.stopPropagation()

        target.classList.toggle("active")
      })
    })
  }, 800);

  const contentReview = document.querySelector(".cate_case");
	if (contentReview) {

		const io = new IntersectionObserver(entries => {
			entries.forEach(entry => {
				if (entry.intersectionRatio > 0) {
					entry.target.classList.add("active")
				} else {
					entry.target.classList.remove("active")
				}
			})
		})

		const sections = document.querySelectorAll(".cate_case .sec_case .part_area");
		sections.forEach(section => {
			io.observe(section)
		})
	}

  const showModal = (event) => {
      const modalData = event.target.dataset.modal
      const modals = document.querySelectorAll(".modal")
      modals.forEach(modal => {

        if(modal.classList.contains(modalData)) {
          modal.classList.add("active")
  
        }

        const close = modal.querySelector(".close");
        close.addEventListener("click", (event) => {
            const modal = event.target.closest(".modal");
            modal.classList.remove("active");
        })
      })
  }

  const modalButtons = document.querySelectorAll("[data-modal]");
  modalButtons.forEach(button => {
      button.addEventListener("click", showModal)
  })

  // 쇼핑 페이지
  const shoppingContent = document.querySelector(".cate_intro.shopping")
  if(shoppingContent) {

    const io = new IntersectionObserver(entries => {
      entries.forEach(entry => {
        if(entry.intersectionRatio > 0) {
          entry.target.classList.add("is_active");
          if (entry.target.classList.contains("section_not_expensive")) {
            document.addEventListener("scroll", () => {
              const coins = document.querySelector(".coins");
              coins.style.opacity = "1";
              coins.style.animation = "none";
              coins.style.transform = `translateY(${(window.pageYOffset - entry.target.offsetHeight) * -.5}px)`;
            })
          }
        } else {
          entry.target.classList.remove("is_active")
        }
      })
    })

    const sections = document.querySelectorAll(".cate_intro.shopping section");
    sections.forEach(section => {
      io.observe(section)
    })
  }
})