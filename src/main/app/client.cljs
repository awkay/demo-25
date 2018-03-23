(ns app.client
  (:require [fulcro.client :as fc]
            [app.ui.root :as root]
            [fulcro.i18n :as i18n]
            ["intl-messageformat" :as MessageFormat]))

(defn message-format [{:keys [::i18n/localized-format-string ::i18n/locale ::i18n/format-options]}]
  (let [locale-str (name locale)
        formatter  (MessageFormat. localized-format-string locale-str)]
    (.format formatter (clj->js format-options))))

(defonce app (atom nil))

(defn mount []
  (reset! app (fc/mount @app root/Root "app")))

(defn start []
  (mount))

(defn ^:export init []
  (reset! app (fc/new-fulcro-client
                :reconciler-options {:shared    {::i18n/message-formatter message-format}
                                     :shared-fn ::i18n/current-locale}))
  (start))
