const {Link} = window.ReactRouterDOM;

const Home = () => {
    return(
        <div>
            <Link to={"/users"}>
                Users
            </Link>
            <br/>
            <Link to={"/courses"}>
                Courses
            </Link>
            <br/>
            <Link to={"/lessons"}>
                Lessons
            </Link>
        </div>
    )
}

export default Home