#ifndef AMENDLANDWINDOW_H
#define AMENDLANDWINDOW_H

#include <QWidget>

namespace Ui {
class AmendLandWindow;
}

class AmendLandWindow : public QWidget
{
    Q_OBJECT

public:
    explicit AmendLandWindow(QWidget *parent = nullptr);
    ~AmendLandWindow();

private:
    Ui::AmendLandWindow *ui;
};

#endif // AMENDLANDWINDOW_H
