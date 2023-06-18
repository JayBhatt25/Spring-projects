export default function ErrorComponent({error}){
    return (
        <div className="error_component">
            {error?(
                <div>
                    <h1>error.message</h1>
                    <div>
                        Apologies for the error. Reach out to our team at nobodycares.com
                    </div>
                </div>
            ):(
                <div>
                    <h1>Error 404: Page not found</h1>
                    <div>
                        Apologies for the error. Reach out to our team at nobodycares.com
                    </div>
                </div>
            )
        }
           
        </div>
    )
}