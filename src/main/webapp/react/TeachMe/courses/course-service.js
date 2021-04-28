const COURSE_URL = "http://localhost:8080/api/courses";

const findAllCourses = () => {
    return  fetch(COURSE_URL).then(response => response.json())
};

const findCourseById = (cid) => {
    return  fetch(`${COURSE_URL}/${cid}`)
        .then(response => response.json())
};

const deleteCourse = (cid) => {
    return fetch(`${COURSE_URL}/${cid}/delete`)
        .then(() => {})
};

const createCourse = (course) =>
    fetch(COURSE_URL, {
        method: 'POST',
        body: JSON.stringify(course),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json());

const updateCourse = (cid, course) =>
    fetch(`${COURSE_URL}/${cid}`, {
        method: 'PUT',
        body: JSON.stringify(course),
        headers: {'content-type': 'application/json'}
    })
        .then(response => response.json());

const updateOwner = (cid, ownerId) => {
    return fetch(`${COURSE_URL}/${cid}/${ownerId}`)
        .then(() => {})
}

const findOwner = (cid) => {
    return fetch(`${COURSE_URL}/${cid}/owner`)
        .then((response) => response.json())
}

const findCourseLessons = (cid) => {
    return  fetch(`${COURSE_URL}/${cid}/lessons`).then(response => response.json())
}

export default {
    findAllCourses,
    findCourseById,
    deleteCourse,
    createCourse,
    updateCourse,
    updateOwner,
    findOwner,
    findCourseLessons
}