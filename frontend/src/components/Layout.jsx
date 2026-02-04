import Navbar from "./Navbar";

function Layout({children}) {
    return (
        <div className="page-container">
            <Navbar />
            {children}
        </div>
    );
}

export default Layout;