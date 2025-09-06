import "./card.css"

interface CardsProps {
    price: number,
    title: string,
    image: string
}

export function Card({ price, image, title }: CardsProps) {
    return(
        <div className="card">
            <img src={image}/>
            <h2>{title}</h2>
            <p><b>Valor: </b>{price}</p>
        </div>
    )
}