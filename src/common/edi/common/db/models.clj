(ns edi.common.db.models)

(def models
  {:documents                   (array-map :sender {:type :text :required true}
                                           :timestamp {:type :timestamp :required true :alias :ts}
                                           :doctype {:type :text :required true}
                                           :id {:type :uuid :required true}
                                           :office {:type :uuid}
                                           :body {:type :json :required true}
                                           :checksum {:type :text}
                                           :msg_for {:type :uuid})

   :event_parcel_order_return   (array-map :sender {:type :text :required true}
                                           :timestamp {:type :timestamp :required true :alias :ts}
                                           :msgtype {:type :text :required true}
                                           :id {:type :uuid :required true}
                                           :order_id {:type :text :required true}
                                           :reason {:type :text :required true}
                                           :items {:type :json :required true}
                                           :total_price {:type :money :required true}
                                           :money_back {:type :boolean :required true}
                                           :money_dest {:type :text :required true}
                                           :document_id {:type :text}
                                           :origin {:type :uuid}
                                           :owner {:type :uuid}
                                           :msg_for {:type :uuid})

   :event_parcel_change_state   (array-map :sender {:type :text :required true}
                                           :timestamp {:type :timestamp :required true :alias :ts}
                                           :msgtype {:type :text :required true}
                                           :id {:type :uuid :required true}
                                           :state {:type :text :required true}
                                           :pentity {:type :uuid}
                                           :weight {:type :integer}
                                           :dimensions {:type :json}
                                           :parcel_source {:type :text}
                                           :external_ref {:type :text}
                                           :delivery_service {:type :text}
                                           :is_quasi {:type :boolean}
                                           :origin {:type :uuid}
                                           :owner {:type :uuid}
                                           :msg_for {:type :uuid})

   :fms_contragent_announcement (array-map :sender {:type :text :required true}
                                           :timestamp {:type :timestamp :required true :alias :ts}
                                           :contragent_id {:type :uuid :required true}
                                           :contragent_reg_id {:type :text :required true}
                                           :action {:type :text :required true}
                                           :reason {:type :text :required true}
                                           :merchant_id {:type :text}
                                           :comment {:type :text}
                                           :msg_for {:type :uuid})

   :fms_emoney_event            (array-map :sender {:type :text :required true}
                                           :timestamp {:type :timestamp :required true :alias :ts}
                                           :serial {:type :uuid :required true}
                                           :money_type {:type :text :required true}
                                           :account {:type :text :required true}
                                           :emoney_transaction {:type :text :required true}
                                           :transaction_id {:type :uuid :required true}
                                           :emoney_amount {:type :money :required true}
                                           :direction {:type :text :required true}
                                           :action {:type :text :required true}
                                           :reason {:type :text :required true}
                                           :contragent_id {:type :uuid}
                                           :contragent_reg_id {:type :text}
                                           :merchant_id {:type :text}
                                           :note {:type :text}
                                           :source_wallet {:type :text}
                                           :target_wallet {:type :text}
                                           :msg_for {:type :uuid})

   :order_payment               (array-map :sender {:type :text :required true}
                                           :timestamp {:type :timestamp :required true :alias :ts},
                                           :id {:type :uuid :required true}
                                           :parcel_id {:type :uuid :required true}
                                           :contragent_id {:type :uuid :required true}
                                           :posop {:type :text :required true}
                                           :posorder_id {:type :text :required true}
                                           :merchant_id {:type :text :required true}
                                           :amount {:type :money :required true}
                                           :payer_phone {:type :text}
                                           :comment {:type :text}
                                           :operation {:type :text}
                                           :correction_id {:type :uuid}
                                           :msg_for {:type :uuid})

   :refill_payment              (array-map :sender {:type :text :required true}
                                           :timestamp {:type :timestamp :required true :alias :ts},
                                           :id {:type :uuid :required true}
                                           :payer_phone {:type :text :required true}
                                           :user_id {:type :text}
                                           :dest {:type :text :required true}
                                           :posop {:type :text :required true}
                                           :posorder_id {:type :text :required true}
                                           :merchant_id {:type :text :required true}
                                           :amount {:type :money :required true}
                                           :comment {:type :text}
                                           :msg_for {:type :uuid})

   :wms_event                   (array-map :serial {:type :uuid :required true}
                                           :items {:type :json :required true}
                                           :condition {:type :text :required true :alias :cond}
                                           :ev_type {:type :text}
                                           :ev_task {:type :text}
                                           :ev_stage {:type :text}
                                           :coordinates {:type :json}
                                           :flow {:type :text}
                                           :direction {:type :text}
                                           :reason {:type :text}
                                           :version {:type :text}
                                           :origin {:type :uuid}
                                           :owner {:type :uuid}
                                           :msg_for {:type :uuid})

   :wms_item_announcement       (array-map :serial {:type :uuid :required true}
                                           :item {:type :json :required true}
                                           :zone_from {:type :text}
                                           :zone_to {:type :text}
                                           :reference {:type :uuid :required true}
                                           :version {:type :text}
                                           :flow {:type :text}
                                           :origin {:type :uuid}
                                           :owner {:type :uuid}
                                           :msg_for {:type :uuid})

   :wms_registry_announcement   (array-map :source {:type :text :required true}
                                           :timestamp {:type :timestamp :required true :alias :ts},
                                           :generated {:type :integer :required true :alias :gener}
                                           :serial {:type :bigint :required true}
                                           :uid {:type :uuid :required true}
                                           :userial {:type :uuid :required true}
                                           :state {:type :text :required true}
                                           :msg_for {:type :uuid})

   :wms_stocktaking_message     (array-map :serial {:type :uuid :required true}
                                           :reference {:type :uuid :required true}
                                           :message_type {:type :text :required true}
                                           :label {:type :text}
                                           :item {:type :json}
                                           :version {:type :text}
                                           :origin {:type :uuid}
                                           :owner {:type :uuid}
                                           :msg_for {:type :uuid})

   :bms_contragent_update       (array-map :sender {:type :text :required :true}
                                           :timestamp {:type :timestamp :required true :alias :ts}
                                           :id {:type :uuid :required :true}
                                           :origin {:type :uuid :required :true}
                                           :action {:type :text :required :true}
                                           :enabled {:type :json}
                                           :bank_account {:type :json}
                                           :bank_mfo {:type :json}
                                           :bank_name {:type :json}
                                           :name {:type :json}
                                           :reg_id {:type :json}
                                           :tax_id {:type :json}
                                           :type {:type :json}
                                           :vat {:type :json}
                                           :is_proxy {:type :json}
                                           :transit_enabled {:type :json}
                                           :provides_processing_for {:type :json}
                                           :msg_for {:type :uuid})})


(def version 6)
(def migrations {1 {:order_payment [[:add-column :operation {:type :text}]
                                    [:add-column :correction_id {:type :uuid}]]}
                 2 {:event_parcel_change_state [[:add-column :external_ref {:type :text}]]}
                 3 {}
                 4 {:documents                   [[:add-column :msg_for {:type :uuid}]]
                    :event_parcel_order_return   [[:add-column :msg_for {:type :uuid}]]
                    :event_parcel_change_state   [[:add-column :msg_for {:type :uuid}]]
                    :fms_contragent_announcement [[:add-column :msg_for {:type :uuid}]]
                    :fms_emoney_event            [[:add-column :msg_for {:type :uuid}]]
                    :order_payment               [[:add-column :msg_for {:type :uuid}]]
                    :refill_payment              [[:add-column :msg_for {:type :uuid}]]
                    :wms_event                   [[:add-column :msg_for {:type :uuid}]]
                    :wms_item_announcement       [[:add-column :msg_for {:type :uuid}]]
                    :wms_registry_announcement   [[:add-column :msg_for {:type :uuid}]]
                    :wms_stocktaking_message     [[:add-column :msg_for {:type :uuid}]]}
                 5 {:event_parcel_order_return [[:add-column :origin {:type :uuid}]
                                                [:add-column :owner {:type :uuid}]]
                    :event_parcel_change_state [[:add-column :origin {:type :uuid}]
                                                [:add-column :owner {:type :uuid}]]
                    :documents                 [[:add-column :office {:type :uuid}]]
                    :wms_item_announcement     [[:add-column :flow {:type :text}]]}
                 6 {:wms_registry_announcement [[:alter-column :serial {:type :bigint :required true :default "0"}]
                                                [:alter-column :gener {:type :bigint :required true :default "0"}]]}})


; migrations example
#_(def version 2)
#_(def migrations {1 {:documents [[:add-column :altertest {:type     :uuid
                                                           :required true
                                                           :default  {:postgresql "'00000000-0000-0000-0000-000000000000'"
                                                                      :mysql      "0x0"}}]
                                  [:alter-column :altertest {:rename   :alter_test
                                                             :type     :text
                                                             :required false}]
                                  [:alter-column :alter_test {:type     :text
                                                              :required true
                                                              :default  {:postgresql "'00000000-0000-0000-0000-000000000000'"
                                                                         :mysql      "0x0"}}]]}
                   2 {:documents [[:drop-column :alter_test nil]]}})


(def tbtapi-docs-refs {0 "edi#v0.1.0"
                       1 "edi#v0.1.1"
                       2 "edi#v0.1.2"
                       3 "edi#v0.1.3"
                       4 "edi#v0.1.4"
                       5 "edi#v0.2.0"
                       6 "edi#v0.2.0"})

(def tbtapi-docs-ref (tbtapi-docs-refs version))


(def topics
  {:event_parcel [{:table :event_parcel_order_return
                   :when? #(not= "ChangeState" (:msgtype %))}
                  {:table :event_parcel_change_state
                   :when? #(= "ChangeState" (:msgtype %))}]
   :document     [{:table :documents
                   :when? (constantly true)}]})


(defn tables-meta [topic]
  (or (get topics topic)
      [{:table topic
        :when? (constantly true)}]))
