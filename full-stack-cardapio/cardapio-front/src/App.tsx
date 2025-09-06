import { useState } from 'react'
import './App.css'
import { Card } from './components/card/card';
import type { FoodData } from './interface/FoodData';
import { useFoodData } from './hooks/useFoodData';
import { CreateModal } from './components/createModal/createModal';

function App() {
  const {data} = useFoodData();
  const [isModalOpen, setIsModalOpen] = useState(false);

  const handleOpenModal = () => {
    setIsModalOpen(prev => !prev);
  }

  return (
    <>
      <div className='container'>
        <h1>Cardápio</h1>
        <div className='card-grid'>
          {data?.map(foodData => 
            <Card 
              price={foodData.price} 
              title={foodData.title} 
              image={foodData.image} 
            />
          )}
        </div>
        {isModalOpen && <CreateModal closeModal={handleOpenModal}/>}
        <button onClick={handleOpenModal}>Novo Item</button>
      </div>
    </>
  )
}

export default App
