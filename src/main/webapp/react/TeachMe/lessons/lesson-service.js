const LESSONS_URL = "http://localhost:8080/api/lessons"

const findAllLesson = () => {
    return  fetch(LESSONS_URL).then(response => response.json())
}

const findLessonById = (lid) => {
    return  fetch(`${LESSONS_URL}/${lid}`)
        .then(response => response.json())
}

const deleteLesson = (lid) => {
    return fetch(`${LESSONS_URL}/${lid}/delete`)
        .then(() => {})
}

const createLesson = (lesson) =>
    fetch(LESSONS_URL, {
        method: 'POST',
        body: JSON.stringify(lesson),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

const updateLesson = (id, lesson) =>
    fetch(`${LESSONS_URL}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(lesson),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json())

const updateCourse = (lid, courseId) => {
    return fetch(`${LESSONS_URL}/${lid}/${courseId}`)
        .then(() => {})
}
const findCourse = (lid) => {
    return fetch(`${LESSONS_URL}/${lid}/course`)
        .then((response) => response.json())
}

export default {
    findAllLesson,
    findLessonById,
    deleteLesson,
    createLesson,
    updateLesson,
    updateCourse,
    findCourse
}