import { useEffect, useState } from "react";
import { getHello } from "../services/helloService";

export function useHello() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    getHello().then(setMessage);
  }, []);

  return message;
}
