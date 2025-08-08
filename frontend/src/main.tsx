import { ClerkProvider } from "@clerk/clerk-react";
import { BrowserRouter } from "react-router-dom";
import { neobrutalism } from "@clerk/themes";
import App from "./App.tsx";
import "./index.css";
import { StrictMode } from "react";
import { createRoot } from "react-dom/client";

// Import your Publishable Key
const CLERK_KEY = import.meta.env.VITE_CLERK_PUBLISHABLE_KEY;

if (!CLERK_KEY) {
  throw new Error("Missing Publishable Key");
}

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <ClerkProvider
      appearance={{
        baseTheme: neobrutalism,
      }}
      publishableKey={CLERK_KEY}
    >
      <BrowserRouter>
        <App />
      </BrowserRouter>
    </ClerkProvider>
  </StrictMode>
);
