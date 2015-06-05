(ns address-book.core.views.address-book-layout
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.core :refer [html h]]
            [selmer.parser :as selmer :refer [render-file]]
            [address-book.core.models.query-defs :as query]))

(selmer.parser/cache-off!)

(defn first-contact []
  (let [x (query/all-contacts)] (first x)))

(defn common-layout [contacts]
  (render-file "templates/home.html" {:contacts contacts}))

(defn add-contact-form []
  (html
    [:div.contact
      [:form {:action "/post" :method "post"}
        [:div.column-1
          [:input#name-input {:type "text" :name "name" :placeholder "Name"}]]
        [:div.column-2
          [:input#phone-input {:type "text" :name "phone" :placeholder "Phone"}]]
        [:div.column-3
          [:input#email-input {:type "text" :name "email" :placeholder "Email"}]]
        [:button.button.add {:type "submit"} "Add "]]
        [:div.clear-row]]))

(defn read-contact [contact]
  (render-file "templates/edit.html" {:contact contact}))

(defn edit-contact [contact]
  (render-file "templates/edit.html" {:contact contact}))
