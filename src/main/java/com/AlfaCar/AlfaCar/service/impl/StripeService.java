//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.AlfaCar.AlfaCar.service.impl;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.LineItem;
import com.stripe.param.checkout.SessionCreateParams.Mode;
import com.stripe.param.checkout.SessionCreateParams.LineItem.PriceData;
import com.stripe.param.checkout.SessionCreateParams.LineItem.PriceData.ProductData;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class StripeService {
    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    public String criarSessaoDePagamento(BigDecimal valor, String descricao) throws StripeException {
        Stripe.apiKey = this.stripeSecretKey;
        SessionCreateParams params = SessionCreateParams.builder().setMode(Mode.PAYMENT).setSuccessUrl("http://localhost:8080/pagamentos/sucesso").setCancelUrl("http://localhost:8080/pagamentos/cancelado").addLineItem(LineItem.builder().setQuantity(1L).setPriceData(PriceData.builder().setCurrency("brl").setUnitAmount(valor.multiply(new BigDecimal(100)).longValue()).setProductData(ProductData.builder().setName(descricao).build()).build()).build()).build();
        Session session = Session.create(params);
        return session.getUrl();
    }
}
