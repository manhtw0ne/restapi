import Navbar from "./components/Navbar"
import Dashboard from "./pages/dashboard/Dashboard"
import ExpenseDetails from "./pages/expense/ExpenseDetails.tsx"
import ExpenseReports from "./pages/expense/ExpenseReports.tsx"
import NewExpense from "./pages/expense/NewExpense.tsx"
import Login from "./pages/login/Login.tsx"
import Register from "./pages/register/Register.tsx"


const App = () => {
    return (
        <BrowserRouter>
            <Navbar />
            <Routes>
                <Route path="/" element={<Dashboard  />}/>
                <Route path="/login" element={<Login  />}/>
                <Route path="/register" element={<Register  />}/>
                <Route path="/new" element={<NewExpense  />}/>
                <Route path="/view/:expenseId" element={<ExpenseDetails  />}/>
                <Route path="/edit/:expenseId" element={<NewExpense  />}/>
                <Route path="/reports" element={<ExpenseReports  />}/>
            </Routes>
        </BrowserRouter>
    )
}

export default App