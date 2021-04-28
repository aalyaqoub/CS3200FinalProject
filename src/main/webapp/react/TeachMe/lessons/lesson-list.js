import usersService from "./lesson-service"

const {useState, useEffect} = React;

const {Link, useHistory} = window.ReactRouterDOM;

const LessonList = () => {
    const [lessons, setLesson] = useState([])

    const history = useHistory()

    useEffect(() => {
        findAllLessons()
    }, [])

    const findAllLessons = () => {
        usersService.findAllLesson()
            .then((data) => {
                setLesson(data)
            })
    }

    return (
        <div>
            <h2>Lessons Lists {lessons.length}</h2>
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
            <button onClick={() =>
            {history.push("/lessons/new")}}>
                Add Lesson
            </button>
        </div>
    )
}

export default LessonList