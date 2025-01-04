import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { HomePage } from './pages/Home.page';
import FormProduto from './components/Form/FormProduto';
import { ColorSchemeToggle } from './components/ColorSchemeToggle/ColorSchemeToggle';

export default function AppRouter() {
  return(
    <BrowserRouter >
      <Routes>
        <Route path='/' element={<HomePage/>}>
          <Route path='/dashboard' element={<FormProduto/>}/>
          <Route path='/settings' element={<ColorSchemeToggle />}/>
        </Route>
      </Routes>
    </BrowserRouter >
  )
}
