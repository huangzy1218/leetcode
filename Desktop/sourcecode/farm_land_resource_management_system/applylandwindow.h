#ifndef APPLYLANDWINDOW_H
#define APPLYLANDWINDOW_H

#include <QWidget>

namespace Ui {
class ApplyLandWindow;
}

class ApplyLandWindow : public QWidget
{
    Q_OBJECT

public:
    explicit ApplyLandWindow(QWidget *parent = nullptr);
    ~ApplyLandWindow();

private:
    Ui::ApplyLandWindow *ui;
};

#endif // APPLYLANDWINDOW_H
