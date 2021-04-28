import courseService from "./course-service"
const {useState, useEffect} = React;
const {useParams, useHistory, Link} = window.ReactRouterDOM;

const CourseEditor = () => {
    const {courseId} = useParams();
    const [course, setCourse] = useState({});
    const [user, setUser] = useState({});
    const [lessons, setLessons] = useState([])
    const history = useHistory();
    useEffect(() => {
        if (courseId !== "new") {
            findCourseById(courseId)
            findOwner(courseId)
            findCourseLessons(courseId)
        }
    }, [])
    const createCourse = (course) =>
        courseService.createCourse(course)
            .then(() => history.goBack())
    const findCourseById = (courseId) =>
        courseService.findCourseById(courseId).then(course => setCourse(course))
    const deleteCourse = (cid) =>
        courseService.deleteCourse(cid)
            .then(() => history.goBack())
    const updateCourse = (cid, newCourse) =>
        courseService.updateCourse(cid, newCourse)
            .then(() => history.goBack())
    const updateOwner = (cid, ownerId) =>
        courseService.updateOwner(cid, ownerId)
    const findOwner = (cid) =>
        courseService.findOwner(cid).then(user => setUser(user))
    const findCourseLessons = (cid) =>
        courseService.findCourseLessons(cid)
            .then(lesson => setLessons(lesson))

    return (
        <div>
            <h2>Course Editor</h2>
            <label>ID</label>
            <input value={course.id} className="form-control"/><br/>
            <label>Course Name</label>
            <input
                onChange={(e) =>
                    setCourse(course =>
                        ({...course, courseName: e.target.value}))}
                value={course.courseName} className="form-control"/><br/>
            <label>Topic</label>
            <input
                onChange={(e) =>
                    setCourse(course =>
                        ({...course, topic: e.target.value}))}
                value={course.topic} className="form-control"/><br/>
            <label>Owner Id</label><br/>
            <Link to={`/users/${user}`}>
                Link to Owner
            </Link><br/>
            <input
                onChange={(e) => {
                    {
                        courseId !== 'new' &&
                        updateOwner(course.id, e.target.value);
                    }
                    setCourse(course =>
                        ({...course, ownerId: e.target.value}))
                }}
                value={course.ownerId} className="form-control"/><br/>
            <h2>Course Lessons</h2>
            {
                courseId !== 'new' && lessons &&
                <ul>
                    {lessons.map((lesson) => {
                        return (
                            <li>
                                <Link to={`/lessons/${lesson.id}`} >
                                    {lesson.id},
                                    {lesson.title}
                                </Link>
                            </li>
                        )
                    })
                    }
                </ul>
            }
            <button
                onClick={() => {
                    history.goBack()}}>
                Cancel
            </button>
            <button
                onClick={() => deleteCourse(course.id)}>
                Delete
            </button>
            <button
                onClick={() => createCourse(course)}>
                Create
            </button>
            <button
                onClick={() => updateCourse(course.id, course)}>
                Save
            </button>
        </div>
    )
}

export default CourseEditor