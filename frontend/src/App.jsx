import { useHello } from "./hooks/useHello";

function App() {
  const message = useHello();

  return (
    <div>
      <h1>Frontend React</h1>
      <p>{message}</p>
    </div>
  );
}

export default App
