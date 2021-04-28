import lessonService from "./lesson-service"
// import courseService from "../courses/course-service";
const {useState, useEffect} = React;
const {useParams, useHistory, Link} = window.ReactRouterDOM;

const LessonEditor = () => {
    const {lessonId} = useParams();
    const [lesson, setLesson] = useState({});
    const [course, setCourse] = useState({});
    const history = useHistory()
    useEffect(() => {
        if (lessonId !== "new") {
            findLessonById(lessonId)
            findCourse(lessonId)
        }
    }, [])
    const createLesson = (lesson) =>
        lessonService.createLesson(lesson)
            .then(() => history.goBack())
    const findLessonById = (lessonId) =>
        lessonService.findLessonById(lessonId).then(lesson => setLesson(lesson))
    const deleteLesson = (lid) =>
        lessonService.deleteLesson(lid)
            .then(() => history.goBack())
    const updateLesson = (lid, newLesson) =>
        lessonService.updateLesson(lid, newLesson)
            .then(() => history.goBack())
    const updateCourse = (lid, courseId) =>
        lessonService.updateCourse(lid, courseId)
    const findCourse = (lid) =>
        lessonService.findCourse(lid).then(course => setCourse(course))


    return (
        <div>
            <h2>Lesson Editor</h2>
            <label>ID</label>
            <input value={lesson.id} className="form-control"/><br/>
            <label>Title</label>
            <input
                onChange={(e) =>
                    setLesson(lesson =>
                        ({...lesson, title: e.target.value}))}
                value={lesson.title} className="form-control"/><br/>
            <label>Text</label>
            <input
                onChange={(e) =>
                    setLesson(lesson =>
                        ({...lesson, text: e.target.value}))}
                value={lesson.text} className="form-control"/><br/>
            <label>Video Link</label>
            <input
                onChange={(e) =>
                    setLesson(lesson =>
                        ({...lesson, videoLink: e.target.value}))}
                value={lesson.videoLink} className="form-control"/><br/>
            <label>Linked Course</label><br/>
            <Link to={`/courses/${course}`}>
                Link to Course
            </Link><br/>
            <input
                onChange={(e) => {
                    {
                        lessonId !== 'new' &&
                        updateCourse(lessonId.id, e.target.value)
                    }
                    setLesson(lesson =>
                        ({...lesson, courseId: e.target.value}))
                }}
                value={lesson.courseId} className="form-control"/><br/>
            <button
                onClick={() => {
                    history.goBack()}}>
                Cancel
            </button>
            <button
                onClick={() => deleteLesson(lesson.id)}>
                Delete
            </button>
            <button
                onClick={() => createLesson(lesson)}>
                Create
            </button>
            <button
                onClick={() => updateLesson(lesson.id, lesson)}>
                Save
            </button>
        </div>
    )
}

export default LessonEditor