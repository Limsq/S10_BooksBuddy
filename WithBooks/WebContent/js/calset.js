document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');

	var calendar = new FullCalendar.Calendar(calendarEl, {
		HeaderToolvar: {
			left: 'prev,next today',
			center: 'title',
			right: 'dayGridMonth,timeGridWeek,timeGridDay'
		},
		initialDate: '2023-01-02',
		editable: true,
		droppable: true,
		navLinks: true,
		selectable: true,
		selectMirror: true,
		select: function(arg) {
			console.log(arg);

			var title = prompt('입력할 일정 : ');
			if (title) {
				calendar.addEvent({
					title: title,
					start: arg.start,
					end: arg.end,
					allDay: arg.allDay,
					backgroundColor: "green",
					textColor: "white"
				})
			}
		},
		drop: function(arg) {
			// is the "remove after drop" checkbox checked?
			if (document.getElementById('drop-remove').checked) {
				// if so, remove the element from the "Draggable Events" list
				arg.draggedEl.parentNode.removeChild(arg.draggedEl);
			}
		},
		eventClick: function(arg) {
			console.log(">등록된 일정 클릭<");
			console.log(arg.event);

			// 상세내용 모달 띄우기
		},
		events: data
	});
calendar.rendar();
});