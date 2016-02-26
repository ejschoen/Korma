(defproject korma "0.4.4"
  :description "Tasty SQL for Clojure"
  :url "http://github.com/korma/Korma"
  :repositories ^:replace [["releases" {:url "https://prod.i2kconnect.com/artifactory/libs-release"
                                        :username "i2kdev" :password "AP4WKeyKBALnrFLRQcTvgip6zndxT1k2pmqWAu"}]
                           ["snapshots" {:url "https://prod.i2kconnect.com/artifactory/libs-snapshot"
                                         :username "i2kdev" :password "AP4WKeyKBALnrFLRQcTvgip6zndxT1k2pmqWAu"}]]
  :deploy-repositories [["releases" {:url "https://prod.i2kconnect.com/artifactory/libs-release-local"
                                     :username "i2kdev" :password "AP4WKeyKBALnrFLRQcTvgip6zndxT1k2pmqWAu"}]
                        ["snapshots" {:url "https://prod.i2kconnect.com/artifactory/libs-snapshot-local"
                                      :username "i2kdev" :password "AP4WKeyKBALnrFLRQcTvgip6zndxT1k2pmqWAu"}]]
  :mailing-list {:name "Korma Google Group"
                 :subscribe "https://groups.google.com/group/sqlkorma"}
  :codox {:exclude [korma.sql.engine
                    korma.sql.fns
                    korma.sql.utils]
          :src-dir-uri "https://github.com/korma/Korma/blob/v0.4.2/"
          :src-linenum-anchor-prefix "L"}

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [c3p0/c3p0 "0.9.1.2"]
                 [org.clojure/java.jdbc "0.3.7"]]

  :min-lein-version "2.0.0"

  :profiles {:dev {:dependencies [[gui-diff "0.6.6"]
                                  [postgresql "9.3-1102.jdbc41"]
                                  [slamhound "1.5.5"]
                                  [criterium "0.4.3"]]
                   :plugins [[codox "0.8.12"]
                             [jonase/eastwood "0.2.1"]
                             [lein-localrepo "0.5.3"]]}
             :test {:dependencies [[mysql/mysql-connector-java "5.1.35"]
                                   [com.h2database/h2 "1.4.187"]
                                   [criterium "0.4.3"]]}
             :1.3 {:dependencies [[org.clojure/clojure "1.3.0"]]}
             :1.4 {:dependencies [[org.clojure/clojure "1.4.0"]]}
             :1.5 {:dependencies [[org.clojure/clojure "1.5.1"]]}
             :1.6 {:dependencies [[org.clojure/clojure "1.6.0"]]}
             :1.7 {:dependencies [[org.clojure/clojure "1.7.0-beta2"]]}}
  :aliases {"run-tests" ["with-profile" "1.3:1.4:1.5:1.6:1.7" "test"]
            "slamhound" ["run" "-m" "slam.hound"]}
  :jvm-opts ["-Dline.separator=\n"])
