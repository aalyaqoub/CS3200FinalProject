import courseService from "./course-service"

const {useState, useEffect} = React;
const {Link, useHistory} = window.ReactRouterDOM;
const CourseList = () => {
    const [courses, setCourse] = useState([]);

    const history = useHistory();

    useEffect(() => {
        findAllCourses()
    }, []);

    const findAllCourses = () => {
        courseService.findAllCourses()
            .then((data) => {
                setCourse(data)
            })
    };

    return (
        <div>
            <h2>Course Lists {courses.length}</h2>
            <ul>
                {courses.map((course) => {
                    return (
                        <li>
                            <Link to={`/courses/${course.id}`} >
                                {course.id},
                                {course.courseName},
                                {course.topic}
                            </Link>
                        </li>
                    )
                })
                }
            </ul>
            <button onClick={() =>
            {history.push("/courses/new")}}>
                Add Course
            </button>
        </div>
    )
};

export default CourseList